import React, { useState } from "react";
import { Menu, Dropdown } from "semantic-ui-react";

import Notifications from "components/Notifications/Notifications";

import pinway_logo from "images/pinway_logo.png";
import placeholder from  "images/place_holder.png";



const HomeMenu = () => {

  return (
    <div>
      <nav style={{backgroundColor: '#d7a8f5', padding: '5px'}} className="navbar navbar-expand-lg">
        <div className="container-fluid">
          <a className="navbar-brand" href="/#">
            <img src={pinway_logo} alt="" width="132" height="32" className="d-inline-block align-text-top"></img>
          </a>
          <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div className="navbar-nav">
            <button style={{paddingRight: '10px'}} type="button" className="btn btn-outline-secondary pr-3">New</button>
            </div>
          </div>
          <div className="d-flex">
              <Notifications/>
              <img src={placeholder} alt="" width="35" height="35" className="rounded-circle"></img>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default HomeMenu;