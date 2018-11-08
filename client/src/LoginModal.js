import React, {Component, Fragment} from 'react';
import './App.css'
import PropTypes from "prop-types";

class LoginModal extends Component {
    static propTypes = {
        closeFunction: PropTypes.func.isRequired
    };

    state = {
        userNameInput: "",
        passwordInput: "",
        errorEncountered: false
    };

    attemptLogin = () => {

    }
    ;

    handleUsernameWriter = (event) => {
        this.setState({userNameInput: event.target.value})
    };

    handlePasswordWriter = (event) => {
        this.setState({passwordInput: event.target.value})
    };

    render () {
        return (
            <Fragment>
                <div className="darkenedBackground"></div>
                <div className="loginModal">
                    <h3>Logga In</h3>
                    <hr/>
                    {this.state.errorEncountered && <div>Login misslyckades</div>}
                    <span className="MainLoginSpan">
                        <b>Användarnamn:</b><input type="text" className="loginput" id="nameInput" onClick={this.handleUsernameWriter}/><br/>
                        <b>Lösenord:</b><input type="text" className="loginput" id="passInput" onClick={this.handlePasswordWriter}/><br/>
                        <button className="loginModalButton" onClick={this.attemptLogin}>Logga In</button><button className="loginModalButton" onClick={this.props.closeFunction}>Avbryt</button>
                    </span>

                </div>
            </Fragment>
        )
    }
}

export default LoginModal;
