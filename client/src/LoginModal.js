import React, {Component, Fragment} from 'react';
import './App.css'
import PropTypes from "prop-types";

class LoginModal extends Component {
    static propTypes = {
        onClose: PropTypes.func.isRequired,
        isOpen: PropTypes.bool.isRequired,
    };

    state = {
        userNameInput: "",
        passwordInput: "",
        errorEncountered: false,
        data: []
    };

    attemptLogin = () => {
        fetch('http://localhost:8080/login', {
            method: 'post',
            headers: {'Content-Type':'application/json'},
            body:JSON.stringify( {
                "username":this.state.userNameInput,
                "password": this.state.passwordInput,   
            })})
            .then(response => 
                response.json().then(data => ({
                    data: data,
                    status: response.status
                })
            ).then(res => {
                 console.log(res.data)
            }));
    }
   





    handleUsernameWriter = (event) => {
        this.setState({userNameInput: event.target.value})
    };

    handlePasswordWriter = (event) => {
        this.setState({passwordInput: event.target.value})
    };

    render () {
        return (
            <Fragment>
                {this.props.isOpen && <Fragment><div className="darkenedBackground"></div>
                <div className="loginModal">
                    <h3>Logga In</h3>
                    <hr/>
                    {this.state.errorEncountered && <div>Login misslyckades</div>}
                    <span className="MainLoginSpan">
                        <p>Användarnamn:</p><input type="text" className="loginput" id="nameInput" onChange={this.handleUsernameWriter}/><br/>
                        <p>Lösenord:</p><input type="password" className="loginput" id="passInput" onChange={this.handlePasswordWriter}/><br/>
                        <button className="loginModalButton" onClick={this.attemptLogin}>Logga In</button><button className="abortModalButton" onClick={this.props.onClose}>Avbryt</button>
                    </span>

                </div></Fragment> }
            </Fragment>
        );
    }
}

export default LoginModal;
