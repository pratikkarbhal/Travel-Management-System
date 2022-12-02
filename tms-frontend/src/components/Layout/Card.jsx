import React from 'react';
import { NavLink } from "react-router-dom";

const Card = ({ 
    imgsrc,
    title,
    path,
    info
}) => {

    return (
        <>
            <div className="col-md-4 col-10 mx-auto">
                <div className="card">
                    <img src={imgsrc} className="card-img-top" id="coverImg" alt="card" />
                    <div className="card-body">
                        <h5 className="card-title">{title}</h5>
                        <p className="card-text">{info}</p>
                        <NavLink to={path} className="btn btn-primary">More details</NavLink>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Card;
