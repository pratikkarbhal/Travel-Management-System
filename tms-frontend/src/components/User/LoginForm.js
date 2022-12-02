import { useState, useRef, useContext } from "react";
import { Link, useHistory } from "react-router-dom";

import AuthContext from "../../store/auth-context";

const LoginForm = () => {
  const userNameInputRef = useRef();
  const passwordInputRef = useRef();
  const history = useHistory();

  const authCtx = useContext(AuthContext);

  const [isLoading, setIsLoading] = useState(false);

  let [authMode, setAuthMode] = useState("signin");

  const changeAuthMode = () => {
    setAuthMode(authMode === "signin" ? "signup" : "signin");
  };

  const submitHandler = (event) => {
    event.preventDefault();
    const enteredUserName = userNameInputRef.current.value;
    const enteredPassword = passwordInputRef.current.value;

    setIsLoading(true);
    if (enteredUserName === "admin" && enteredPassword === "admin@123") {
      setIsLoading(false);
      alert("Logged In");
      authCtx.login("admin");
      history.replace("/home");
    } else if (
      enteredUserName === "customer" &&
      enteredPassword === "customer@123"
    ) {
      setIsLoading(false);
      alert("Logged In");
      authCtx.login("customer");
      history.replace("/home");
    } else {
      setIsLoading(false);
      alert("Invalid Credentials");
      history.replace("/auth");
    }
  };

  return (
    <div className="row">
      <div className="Auth-form-container">
        <form
          className="Auth-form"
          name="login-form"
          autoComplete="on"
          onSubmit={submitHandler}
        >
          <div className="Auth-form-content">
            <h3 className="Auth-form-title">Login</h3>
            <div className="text-center">
              Not registered yet?{" "}
              <Link to="/signup">
                <span className="link-primary" onClick={changeAuthMode}>
                  Sign Up
                </span>
              </Link>
            </div>
            <div className="form-group mt-3">
              <label htmlFor="userName">Your Username</label>
              <input
                type="text"
                id="email"
                className="form-control mt-1"
                placeholder="Enter username"
                autoFocus
                minLength="5"
                required
                ref={userNameInputRef}
              />
            </div>
            <div className="form-group mt-3">
              <label htmlFor="password">Your Password</label>
              <input
                type="password"
                id="password"
                className="form-control mt-1"
                placeholder="Enter password"
                autoComplete="off"
                minLength="6"
                required
                ref={passwordInputRef}
              />
            </div>
            <div className="d-grid gap-2 mt-3">
              {!isLoading && (
                <button
                  type="submit"
                  className="btn btn-primary"
                  disabled={!userNameInputRef || !passwordInputRef}
                >
                  Submit
                </button>
              )}
              {isLoading && <p>Sending request...</p>}
            </div>
          </div>
        </form>
      </div>
    </div>
  );
};

export default LoginForm;
