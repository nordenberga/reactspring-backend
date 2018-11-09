import React, {Component} from 'react';
import './App.css';
import {Link} from 'react-router-dom';
import logo from './logo.png';

class SignUpPage extends Component {
    state = {
        messageVisible: false,
        messageContent: "något gick fel, försök igen.",
        userLoginSuccessful: false,
        userNameInput: "",
        passwordInput: "",
        repeatInput: ""
    };

    handleUsernameWriter = (event) => {
        this.setState({userNameInput: event.target.value})
    };

    handlePasswordWriter = (event) => {
        this.setState({passwordInput: event.target.value})
    };

    handleRepeatWriter = (event) => {
        this.setState({repeatInput: event.target.value})
    };

    attemptUserCreation = () => {
        if (this.state.passwordInput.length < 3 || this.state.userNameInput < 3) {
            this.setState({messageVisible: true, messageContent: "Lösenord och användarnamn måste bestå av minst tre tecken."})
        }

        else {
            fetch('http://localhost:8080/addUser',
                {
                    method: 'post',
                    headers: {'Content-Type': 'application/json'},
                    body:JSON.stringify(
                        {
                            "username": this.state.userNameInput,
                            "password": this.state.passwordInput,
                        }
                    )
                }).then(response => response.json())
                .then(json => {
                        console.log(json);
                    }
                )

        }
    };


    render () {
      return (
          <div className="App">
              <img src={logo} alt="" className="smallerImage"/>
              {this.state.messageVisible && <div>{this.state.messageContent}</div>}
              <h2>Skapa konto: </h2>
              <span className="MainLoginSpan">
                        <p>Användarnamn:</p><input type="text" className="loginput" id="nameInput" onChange={this.handleUsernameWriter}/><br/>
                        <p>Lösenord:</p><input type="password" className="loginput" id="passInput" onChange={this.handlePasswordWriter}/><br/>
                        <p>Upprepa Lösenord:</p><input type="password" className="loginput" id="repInput" onChange={this.handleRepeatWriter}/><br/>
                        <button className="loginModalButton" onClick={this.attemptUserCreation}>Logga In</button>
                  <Link  to="/"><button className="abortModalButton">Tillbaka</button></Link>
              </span>
          </div>
      )
    };
}
export default SignUpPage;

