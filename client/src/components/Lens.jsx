import React , {useEffect, useState} from 'react';
import axios from 'axios';

function Lens(){
  const [lens, setBooks] = useState(null);
  async function getLens() {
    try{
      const res = await axios.get("http://localhost:8080/lens");
      setBooks(res.data)
    }catch(e){
      console.error(e, e.message);
    }
  }
  
  useEffect( ()=> {
    getLens();

  }, [] ) // [] prevents the app to continue to refresh

  const [input, setInput] = useState(null);

  function handleChange(e) {
    const { id, value } = e.target;
    setInput({...input, [id]:value })
    console.log("coming from handle change",input)
  }

  async function handleSubmit(e) {
    e.preventDefault();

    try {
      await axios.post("http://localhost:8080/lens", input);

    }catch(e) {
      console.error(e, e.message)
    }
    getLens()
  }

  async function deleteLens(e) {
    const { id } = e.target;

    try{
      axios.delete('http://localhost:8080/lens/' + id)
    }catch(e) {
      console.error(e, e.message)
    }
    getLens();
  }
  return (
    <div>
      <h1> Lens </h1> 
      <form 
          className="form-container" 
          onChange={(e) => handleChange(e)}
          onSubmit={(e) => handleSubmit(e)}
        >
          <label> 
            title: <input type="text"  id="name" />
          </label>

          <label> 
            description: <input type="text" id="description"/>
          </label>

          <label> 
            price: <input type="text" id="price" />
          </label>

          <input type="submit" value="Create New Lens"  />
        </form>

        <h3>Cameras:</h3> 
        {lens ?  lens.map(len => <Len camera={len} deleteLens={deleteLens} />) : "Loading ..."  }

    </div>
  )

}
function Len (props) {
  return(
    <div>
      <h1>  { props.lens.name} </h1>
      <button id={props.lens.name} onClick={(e) => props.deleteLens(e)}> Delete </button>
    </div>
  )
}


export default Lens;
