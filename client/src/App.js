import React, {Component, Fragment} from 'react';
import './App.css';
import StartPage from "./StartPage.js"
import LoggedInLandingPage from "./LoggedInLandingPage";
import {BrowserRouter as Router, Link, Route} from 'react-router-dom';

class App extends Component {



  render() {
    return (
      <Router>
          <Fragment>
          <Route exact path="/" component={StartPage}/>
          <Route exact path="/welcome" component={LoggedInLandingPage}/>
          </Fragment>
      </Router>
    );
  }
}

export default App;
