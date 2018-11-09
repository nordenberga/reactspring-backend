import React, {Component, Fragment} from 'react';
import './App.css';
import StartPage from "./StartPage.js"
import SignUpPage from "./SignUpPage";
import LoggedInLandingPage from "./LoggedInLandingPage";
import {BrowserRouter as Router, Link, Route} from 'react-router-dom';

class App extends Component {



  render() {
    return (
      <Router>
          <Fragment>
          <Route exact path="/" component={StartPage}/>
          <Route exact path="/welcome" component={LoggedInLandingPage}/>
              <Route exact path="/signup" component={SignUpPage}/>
          </Fragment>
      </Router>
    );
  }
}

export default App;
