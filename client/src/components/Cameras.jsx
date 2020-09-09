
import React , {useEffect, useState} from 'react';
import axios from 'axios';

function Cameras() {
  const [cameras, setCameras] = useState(null);

  async function getCameras() {
    try{
      const res = await axios.get("http://localhost:8080/camera");
      setCameras(res.data)
    }catch(e){
      console.error(e, e.message);
    }
  }
  
  useEffect( ()=> {
    getCameras();
  }, [] ) 

  const [input, setInput] = useState(null);

  function handleChange(e) {
    const { id, value } = e.target;
    setInput({...input, [id]:value })
  }

  async function handleSubmit(e) {
    e.preventDefault();

    try {
      await axios.post("http://localhost:8080/camera/", input);

    }catch(e) {
      console.error(e, e.message)
    }
    getCameras()
  }

  async function deleteCamera(e) {
    const { id } = e.target;

    try{
      axios.delete('http://localhost:5432/camera/' + id)
    }catch(e) {
      console.error(e, e.message)
    }
    getCameras();
  }


  return (
    <div>
      <h1> CAMERAS </h1> 
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

          <input type="submit" value="Create New Camera"  />
        </form>

        <h3>Cameras:</h3> 
        {cameras ?  cameras.map(camera => <Camera camera={camera} deleteBook={deleteCamera} />) : "Loading ..."  }

    </div>
  )

}

function Camera (props) {
  return(
    <div>
      <h1> { props.camera.name} </h1>
      <h4> {props.camera.price} </h4>
      <p>{props.camera.description} </p>

      <button id={props.camera.name} onClick={(e) => props.deleteCamera(e)}> Delete </button>
    </div>
  )
}


export default Cameras;