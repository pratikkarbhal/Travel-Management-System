import React, { Component } from "react";

class FooterComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {};
  }

  render() {
    return (
      <div>
        <footer id="footer" class="flex-shrink-0 py-2 bg-dark text-white-50">

        <div class="container text-center" >
          <h6>
              <span className="text">Follow Us : </span>
              <button type="button" class="btn btn-primary float-right"> Instagram </button> 
              <button type="button" class="btn btn-primary float-right"> Facebook </button>
              <button type="button" class="btn btn-primary float-right"> Twitter </button>
              <button type="button" class="btn btn-primary float-right"> LinkedIn </button>

              </h6>
              </div>

          <div class="container text-center">
            <h6>
            Contact us:
              <span className="text-muted">  +91 90000 00000 </span>
              </h6>
            <h6>
              Copyright &copy;{" "}
              <span className="text-muted"> All Rights Reserved @tms.com</span>
            </h6>
          </div>

        </footer>
      </div>
    );
  }
}

export default FooterComponent;
