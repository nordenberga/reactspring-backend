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
      <div className="App">
        <header className="App-header">
          <LoginModal closeFunction={this.fakeOnClose}/>
        </header>
      </div>
    );
  }
}

export default App;
