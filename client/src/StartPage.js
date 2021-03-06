import React, { Component } from 'react';
import logo from './logo.png';
import './App.css';
import LoginModal from "./LoginModal.js";
import {Link} from "react-router-dom";

class StartPage extends Component {
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
                    {   this.state.showModal && <LoginModal isOpen={this.state.showModal} onClose={this.hideModal}/>}
                    <Link  to="/signup"><button className="abortModalButton">Registrera</button></Link>
                </header>
            </div>
        )
    }

}

export default StartPage;