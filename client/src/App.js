import React from 'react';
import './App.css';

import Home from './components/Home';
import Cameras from './components/Cameras';
import Lens from './components/Lens';
import Tripods from './components/Tripods'
import Footer from './components/Footer';


import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";


function App() {
  return (
    <div className="App">
      <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/cameras">Cameras</Link>
            </li>
            <li>
              <Link to="/lens">Lens</Link>
            </li>
            <li>
              <Link to="/tripods">Tripods</Link>
            </li>
          </ul>
        </nav>

        <Switch>
          <Route path="/cameras">
            <Cameras />
          </Route>

          <Route path="/lens">
            <Lens />
          </Route>

           <Route path="/tripods">
            <Tripods />
          </Route> 

          <Route path="/">
            <Home />
          </Route> 
        </Switch>
      </div>
    </Router>


    <Footer />
    </div>
  );
}

export default App;
