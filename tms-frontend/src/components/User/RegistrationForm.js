import React, { useState } from "react";
import axios from "axios";
import { Link, useHistory } from "react-router-dom";

export default function RegistrationForm(props) {
  let [authMode, setAuthMode] = useState("signin");
  let [adminName, setAdminName] = useState("");
  let [password, setPassword] = useState("");
  let [email, setEmail] = useState("");
  let [mobile, setMobile] = useState("");

  let history = useHistory();

  const changeAuthMode = () => {
    setAuthMode(authMode === "signin" ? "signup" : "signin");
  };

  const [isLoading, setIsLoading] = useState(false);

  function onCreateUser(e) {
    let select = document.getElementById("role");
    let text = select.options[select.selectedIndex].text;
    e.preventDefault();
    const admin = {
      userType: "admin",
      password: "root",
      customer: null,
      admin: {
        adminName,
        password,
        email,
        mobile,
      },
    };

    const customer = {
      userType: "customer",
      password: "root",
      admin: null,
      customer: {
        customerName: adminName,
        customerPassword: password,
        email: email,
        address: "Mumbai",
        mobileNo: mobile,
      },
    };

    setIsLoading(true);
    if (text === "Admin") {
      axios.post(`http://localhost:8080/user/add`, admin).then((response) => {
        setIsLoading(false);
        console.log(response);
        alert("Admin Registered Successfully");
        history.replace("/auth");
      });
    } else {
      axios
        .post(`http://localhost:8080/user/add`, customer)
        .then((response) => {
          setIsLoading(false);
          console.log(response);
          alert("Customer Registered Successfully");
          history.replace("/auth");
        });
    }
  }

  return (
    <div className="row">
      <div className="Auth-form-container">
        <form className="Auth-form" onSubmit={onCreateUser} autoComplete="on">
          <div className="Auth-form-content">
            <h3 className="Auth-form-title">Sign In</h3>
            <div className="text-center">
              Already registered?{" "}
              <Link to="/auth">
                <span className="link-primary" onClick={changeAuthMode}>
                  Sign In
                </span>
              </Link>
            </div>
            <div className="form-group mt-4">
              <label>Select Role</label>
              <select
                className="form-control mb-3"
                name="role"
                id="role"
                autoFocus
              >
                <option value="Role">Select a role</option>
                <option value="Admin">Admin</option>
                <option value="Customer">Customer</option>
              </select>
            </div>
            <div className="form-group mt-3">
              <label>User Name</label>
              <input
                type="text"
                value={adminName}
                onChange={(e) => setAdminName(e.target.value)}
                className="form-control mt-1"
                required
                placeholder="e.g Jane Doe"
              />
            </div>
            <div className="form-group mt-3">
              <label>Email address</label>
              <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                className="form-control mt-1"
                required
                placeholder="Email Address"
              />
            </div>
            <div className="form-group mt-3">
              <label>Password</label>
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                className="form-control mt-1"
                required
                minLength="6"
                placeholder="Password"
                autoComplete="off"
              />
            </div>

            <div className="form-group mt-3">
              <label>Mobile Number</label>
              <input
                type="tel"
                value={mobile}
                maxLength="10"
                onChange={(e) => setMobile(e.target.value)}
                className="form-control mt-1"
                placeholder="Mobile Number"
              />
            </div>
            <div className="d-grid gap-2 mt-3">
              {!isLoading && (
                <button
                  type="submit"
                  className="btn btn-primary"
                  disabled={!adminName || !email || !password}
                >
                  Submit
                </button>
              )}
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}
