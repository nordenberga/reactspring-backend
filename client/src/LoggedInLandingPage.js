import React, {Component, Fragment} from 'react';
import './App.css'
import FeaturedJobSingle from "./FeaturedJobSingle";
import PropTypes from "prop-types";

class LoggedInLandingPage extends Component {
    state = {
        username: "placeholder",
        featuredJobs: [{title: "mäklare sökes", description: "Hej vi söker mäklare som kan sälja hus i stockholm"},
            {title: "trädgårdsmästare", description: "måste veta hur man vattnar och klipper gräs, bra arbetstider."},
            {title: "kattvakt", description: "behöver någon som kan ta hand om mina katter medan jag är på jobbet. betalning enligt avtal"},
            {title: "målare", description: "måns måleri söker målare som kan måla. vi erbjuder bra lön och spännande arbetsuppgifter. söker någon med minst 1 års erfarenhet av måleri"}]
    };

    renderFeaturedJobs = () => {
        return (this.state.featuredJobs.map(job => <FeaturedJobSingle title={job['title']} description={job['description']}/>));
    };

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
                    <input type="text"/><button>sök</button>
                </div>
            </div>
        )
    }

}
export default LoggedInLandingPage;