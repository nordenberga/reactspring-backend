import React, {Component, Fragment} from 'react';
import './App.css'
import FeaturedJobSingle from "./FeaturedJobSingle";
import PropTypes from "prop-types";
import JobView from "./JobView";

class LoggedInLandingPage extends Component {
    state = {
        username: "placeholder",
        searchText: "",
        searchedJobs: [],
        featuredJobs: []
    };


    componentDidMount() {
        fetch('http://localhost:8080/search/java', {
            method: 'get',
            headers: {'Content-Type':'application/json'}
            })
            .then(response => 
                response.json().then(data => ({
                    data: data,
                    status: response.status
                })
            ).then(res => {
                this.setState({featuredJobs: res.data})
            }));
    }

    renderFeaturedJobs = () => {
        return (this.state.featuredJobs.map(job => <JobView key={job.gitId} job={job} title={job['title']} description={job['location']}/>));
    };


    changeSearchString = (event) => {
        this.setState({searchText: event.target.value})
    }

    searchJobs = () => {
        fetch('http://localhost:8080/search/' + this.state.searchText, {
            method: 'get',
            headers: {'Content-Type':'application/json'}
            })
            .then(response => 
                response.json().then(data => ({
                    data: data,
                    status: response.status
                })
            ).then(res => {
                this.setState({searchedJobs: res.data})
            }));
    }

    handleKeyPress(target) {
        if(target.charCode==13){
            this.searchJobs()     
        }
    
    }

    render() {
        return (
            <div className="landingDiv">
                <h1>Välkommen {this.state.username}!</h1>
                <hr/>
                <div className="featuredJobsDiv">
                    <b className="featuredJobsTitle">Utvalda jobb: </b>
                    {this.renderFeaturedJobs()}
                </div>
                <div className="searchJobsDiv">
                    <b className="searchJobsTitle">Sök jobb: </b>
                    <input type="text" onChange={this.changeSearchString}  onKeyPress={event => {
                    if (event.key === 'Enter') {
                        this.searchJobs();
                    }}}/><button onClick={this.searchJobs}>Sök</button>
                    {this.state.searchedJobs.map(function(job) {
   return <div key={job.gitid}>
            <JobView job={job} visible={true}/></div>
   
})}
                </div>
            </div>
        )
    }

}
export default LoggedInLandingPage;