import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import LoginModal from "./LoginModal.js";

class App extends Component {
  fakeOnClose  = () => {
    console.log("du stängde modalen!!")
  };

  render() {
    return (
      <div>
          <LoginModal closeFunction={this.fakeOnClose}/>
      </div>
    );
  }
}

export default App;
