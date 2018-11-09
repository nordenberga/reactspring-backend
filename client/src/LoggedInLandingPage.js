import React, {Component} from 'react';
import './App.css'
import FeaturedJobSingle from "./FeaturedJobSingle";

class LoggedInLandingPage extends Component {
    state = {
        searchText: "",
        searchedJobs: [],
        featuredJobs: [],
        userNameToRender: "Gäst"
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
        
        if(localStorage.getItem("username_jobs")){
            this.setState({userNameToRender: localStorage.getItem("username_jobs")})
        }
    }

    renderFeaturedJobs = () => {
        return (this.state.featuredJobs.map(job => <FeaturedJobSingle title={job['title']} description={job['location']}/>));
    };


    changeSearchString = (event) => {
        this.setState({searchText: event.target.value})
    };

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
    };

    handleKeyPress(target) {
        if(target.charCode===13){
            this.searchJobs()     
        }
    }

    render() {
        return (
            <div className="landingDiv">
                <h1>Välkommen {this.state.userNameToRender}!</h1>
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
   return <li key={job.id}>{job.title} in {job.location}</li>
   
})}
                </div>
            </div>
        )
    }

}
export default LoggedInLandingPage;