import React, { useContext } from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";

import "./App.css";
import AuthContext from "./store/auth-context";

import ListReportComponent from "./components/Report/ListReportComponent";
import CreateReportComponent from "./components/Report/CreateReportComponent";
import UpdateReportComponent from "./components/Report/UpdateReportComponent";
import ViewReportComponent from "./components/Report/ViewReportComponent";

import ListRouteComponent from "./components/Route/ListRouteComponent";
import CreateRouteComponent from "./components/Route/CreateRouteComponent";
import UpdateRouteComponent from "./components/Route/UpdateRouteComponent";
import ViewRouteComponent from "./components/Route/ViewRouteComponent";

import ListFeedbackComponent from "./components/Feedback/ListFeedbackComponent";
import CreateFeedbackComponent from "./components/Feedback/CreateFeedbackComponent";
import UpdateFeedbackComponent from "./components/Feedback/UpdateFeedbackComponent";
import ViewFeedbackComponent from "./components/Feedback/ViewFeedbackComponent";

import ListBookingComponent from "./components/Booking/ListBookingComponent";
import CreateBookingComponent from "./components/Booking/CreateBookingComponent";
import UpdateBookingComponent from "./components/Booking/UpdateBookingComponent";
import ViewBookingComponent from "./components/Booking/ViewBookingComponent";

import LoginForm from "./components/User/LoginForm";
import RegistrationForm from "./components/User/RegistrationForm";

import MainNavigation from "./components/Layout/MainNavigation";
import FooterComponent from "./components/Layout/FooterComponent";
import LandingPage from "./components/Layout/LandingPage";
import home from "./components/Layout/home";

import explore from "./components/Layout/Services";

function App() {
  const authCtx = useContext(AuthContext);
  const isAdmin = authCtx.token === "admin";
  return (
    <div>
      <Router>
        <div>
          <MainNavigation />
          <Switch>
            <div>
              {!authCtx.isLoggedIn && (
                <Route exact path="/" component={LandingPage}></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route path="/home" component={home}></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route path="/explore" component={explore}></Route>
              )}
              <Route path="/feedbacks">
                {!authCtx.isLoggedIn && <Redirect to="/auth" />}
              </Route>
              <Route path="/routes">
                {!authCtx.isLoggedIn && <Redirect to="/auth" />}
              </Route>
              <Route path="/bookings">
                {!authCtx.isLoggedIn && <Redirect to="/auth" />}
              </Route>
            </div>
          </Switch>
          <div className="container">
            <Switch>
              <Route path="/auth" component={LoginForm}></Route>
              <Route path="/signup" component={RegistrationForm}></Route>

              {authCtx.isLoggedIn && (
                <Route
                  path="/feedbacks"
                  component={ListFeedbackComponent}
                ></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route
                  path="/add-feedback"
                  component={CreateFeedbackComponent}
                ></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route
                  path="/update-feedback"
                  component={UpdateFeedbackComponent}
                ></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route
                  path="/view-feedback/:id"
                  component={ViewFeedbackComponent}
                ></Route>
              )}

              {authCtx.isLoggedIn && (
                <Route path="/routes" component={ListRouteComponent}></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route
                  path="/add-route"
                  component={CreateRouteComponent}
                ></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route
                  path="/update-route"
                  component={UpdateRouteComponent}
                ></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route
                  path="/view-route/:id"
                  component={ViewRouteComponent}
                ></Route>
              )}

              {authCtx.isLoggedIn && (
                <Route
                  path="/bookings"
                  component={ListBookingComponent}
                ></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route
                  path="/add-booking"
                  component={CreateBookingComponent}
                ></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route
                  path="/update-booking"
                  component={UpdateBookingComponent}
                ></Route>
              )}
              {authCtx.isLoggedIn && (
                <Route
                  path="/view-booking/:id"
                  component={ViewBookingComponent}
                ></Route>
              )}

              {authCtx.isLoggedIn && isAdmin && (
                <Route path="/reports" component={ListReportComponent}></Route>
              )}
              {authCtx.isLoggedIn && isAdmin && (
                <Route
                  path="/add-report"
                  component={CreateReportComponent}
                ></Route>
              )}
              {authCtx.isLoggedIn && isAdmin && (
                <Route
                  path="/update-report"
                  component={UpdateReportComponent}
                ></Route>
              )}
              {authCtx.isLoggedIn && isAdmin && (
                <Route
                  path="/view-report/:id"
                  component={ViewReportComponent}
                ></Route>
              )}

              {authCtx.isLoggedIn && (
                <Route path="*">
                  <Redirect to="/home" />
                </Route>
              )}
              {!authCtx.isLoggedIn && (
                <Route path="*">
                  <Redirect to="/" />
                </Route>
              )}
            </Switch>
          </div>
          <FooterComponent />
        </div>
      </Router>
    </div>
  );
}

export default App;
