import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import LoginModal from "./LoginModal.js";

class App extends Component {

  state = {
    showModal: false
};

showTheModal = () => {
    this.setState({showModal:true})
};

hideModal = () => {
    this.setState({showModal:false})

};



  render() {
    return (
      <div className="App">
        <header className="App-header">
        <img src={logo} alt=""/>
        <h1>Apply for a new job today</h1>
          <p onClick={this.showTheModal} className="enticingText">
            Login
          </p>
      {/*    <LoginModal isOpen={this.state.showModal} onClose={this.hideModal}/>*/}
        </header>
      </div>
    );
  }
}

export default App;
