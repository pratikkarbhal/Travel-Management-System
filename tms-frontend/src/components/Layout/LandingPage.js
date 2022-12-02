import React from "react";
import hotel from "../images/landing-page/hotel.webp";
import p1 from "../images/landing-page/p1.webp";
import p2 from "../images/landing-page/p2.webp";
import p3 from "../images/landing-page/p3.webp";
import p4 from "../images/landing-page/p4.webp";
import p5 from "../images/landing-page/p5.webp";
import p6 from "../images/landing-page/p6.webp";
import p7 from "../images/landing-page/p7.webp";
import p8 from "../images/landing-page/p8.webp";
import { Link } from "react-router-dom";

const LandingPage = () => {
  return (
    <div className="landing-page">
      <div className="container-fluid">
        <div className="row">
          <div className="col-6">
            <div className="row">
              <div className="text-center">
                <span className="welcome">
                  HUNDREDS OF AMAZING DESTINATIONS
                </span>
              </div>
            </div>
            <div className="row">
              <Link to="/bookings">
                <button type="button" className="main-button">
                  Book Now
                </button>
              </Link>
            </div>
          </div>
          <div className="col-6">
            <div class="text-center">
              <img
                src={hotel}
                alt="hotel"
                style={{ width: "70%" }}
                className="landingPhoto"
              ></img>
            </div>
          </div>
        </div>
        <div class="spacing"></div>
        <div>
          <hr style={{ height: "5px", color: "royalblue" }} />
        </div>
        <div class="spacing"></div>
        <div className="row">
          <div className="col-3">
            <img
              src={p1}
              alt="hotel"
              style={{ width: "95%" }}
              className="grid"
            ></img>
          </div>
          <div className="col-3">
            <img
              src={p2}
              alt="hotel"
              style={{ width: "95%" }}
              className="grid"
            ></img>
          </div>
          <div className="col-3">
            <img
              src={p3}
              alt="hotel"
              style={{ width: "95%" }}
              className="grid"
            ></img>
          </div>
          <div className="col-3">
            <img
              src={p4}
              alt="hotel"
              style={{ width: "95%" }}
              className="grid"
            ></img>
          </div>
        </div>
        <div className="row">
          <div className="col-3">
            <img
              src={p5}
              alt="hotel"
              style={{ width: "95%" }}
              className="grid"
            ></img>
          </div>
          <div className="col-3">
            <img
              src={p6}
              alt="hotel"
              style={{ width: "95%" }}
              className="grid"
            ></img>
          </div>
          <div className="col-3">
            <img
              src={p7}
              alt="hotel"
              style={{ width: "95%" }}
              className="grid"
            ></img>
          </div>
          <div className="col-3">
            <img
              src={p8}
              alt="hotel"
              style={{ width: "95%" }}
              className="grid"
            ></img>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LandingPage;
