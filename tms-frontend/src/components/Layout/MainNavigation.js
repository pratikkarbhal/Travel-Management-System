import { Link } from "react-router-dom";
import { useContext } from "react";
import AuthContext from "../../store/auth-context";

const MainNavigation = () => {
  const authCtx = useContext(AuthContext);
  const isAdmin = authCtx.token === "admin";
  const logoutHandler = () => {
    authCtx.logout();
  };
  return (
    <div className="navi-bar">
      <header>
        <nav className="navbar navbar-expand-md navbar-dark bg-dark">
          <div>
            <ul>
              <li className="home-nav">
                {authCtx.isLoggedIn && (
                  <Link to="/home">
                    <img
                      src="logo.png"
                      className="tms-logo"
                      width="50px"
                      alt="logo"
                    ></img>
                  </Link>
                )}
                {!authCtx.isLoggedIn && (
                  <Link to="/">
                    <img
                      src="logo.png"
                      className="tms-logo"
                      width="50px"
                      alt="logo"
                    ></img>
                  </Link>
                )}
              </li>

              <li>
                <span className="website"><b>Trip Management System</b><us>______________________________________________________</us></span>
              </li>

              <li className="home-nav">
                <Link to="/bookings">
                  <button class="btn btn-warning">Bookings</button>
                </Link>
              </li>

              <li className="home-nav">
                <Link to="/routes">
                  <button class="btn btn-warning">Routes</button>
                </Link>
              </li>

              {authCtx.isLoggedIn && (
                <li className="home-nav">
                  <Link to="/feedbacks">
                    <button class="btn btn-warning">Feedbacks</button>
                  </Link>
                </li>
              )}

              {authCtx.isLoggedIn && isAdmin && (
                <li className="home-nav">
                  <Link to="/reports">
                    <button class="btn btn-warning">Reports</button>
                  </Link>
                </li>
              )}

              {!authCtx.isLoggedIn && (
                <li className="home-nav">
                  <Link to="/auth">
                    <button type="button" class="btn btn-success">
                      Login
                    </button>
                  </Link>
                </li>
              )}

              {!authCtx.isLoggedIn && (
                <li class="home-nav">
                  <Link to="/signup">
                    <button type="button" class="btn btn-success">
                      SignUp
                    </button>
                  </Link>
                </li>
              )}

              {authCtx.isLoggedIn && (
                <li>
                  <button
                    type="button"
                    class="btn btn-danger"
                    onClick={logoutHandler}
                  >
                    Logout
                  </button>
                </li>
              )}
            </ul>
          </div>
        </nav>
      </header>
    </div>
  );
};

export default MainNavigation;
