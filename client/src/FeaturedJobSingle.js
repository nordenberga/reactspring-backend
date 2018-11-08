import React, {Component, Fragment} from 'react';
import './App.css'
import PropTypes from "prop-types";

class FeaturedJobSingle extends Component {
    static propTypes = {
        title: PropTypes.string.isRequired,
        description: PropTypes.string.isRequired,

    };

    render () {
        return (
            <div className="singleFeaturedJob">
                <hr/>
                <b>{this.props.title}</b><br/>
                <span>{this.props.description}</span>
                </div>
        )
    }
}

export default FeaturedJobSingle;