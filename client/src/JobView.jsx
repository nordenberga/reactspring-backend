import React, { Component } from 'react';
import './App.css';





export default class JobView extends Component {

    state = {
        expandedInformation: false
    };

    showExtraInfo = () => {
        this.setState(prevState => ({
            expandedInformation: !prevState.expandedInformation
          }));
    }
    
    


  render() {
    return (
      <div className="jobview">
        <h3 onClick={this.showExtraInfo} className="clickableHeader">{this.props.job.title} in {this.props.job.location}</h3>
       {this.state.expandedInformation && <div className="Expanded"> 
           <h3>{this.props.job.type}</h3>
           <div dangerouslySetInnerHTML={{__html: this.props.job.description}} onClick={this.showExtraInfo}></div>
        </div>
       }
      </div>
    )
  }
}
