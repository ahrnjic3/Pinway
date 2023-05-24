import React, { useState } from "react";
import { Menu, Dropdown } from "semantic-ui-react";

import pinway_logo from "images/pinway_logo.png";
import placeholder from  "images/place_holder.png";



const HomeMenu = () => {
  const [state, setState] = useState({ activeItem: "patients" });

  const handleItemClick = (e, { name }) => {
    setState({ activeItem: name });
  };

  const { activeItem } = state;

  return (
    <div>
      {/* <nav style={{backgroundColor: '#d7a8f5'}} class="navbar">
        <div class="container-fluid">
          <a class="navbar-brand" href="/#">
            <img src={pinway_logo} alt="" width="132" height="32" class="d-inline-block align-text-top"></img>
          </a>
          <button type="button" class="btn btn-outline-secondary">New</button>
          <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"></input>
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        <div class="d-flex">
            <img src={placeholder} alt="" width="32" height="32" class="rounded-circle"></img>
          </div>
        </div>
      </nav> */}

      <nav style={{backgroundColor: '#d7a8f5', padding: '5px'}} class="navbar navbar-expand-lg">
        <div class="container-fluid">
          <a class="navbar-brand" href="/#">
            <img src={pinway_logo} alt="" width="132" height="32" class="d-inline-block align-text-top"></img>
          </a>
          <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
            <button style={{paddingRight: '10px'}} type="button" class="btn btn-outline-secondary pr-3">New</button>
            <form style={{paddingLeft: '5px'}} class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"></input>
              <button class="btn btn-outline-secondary" type="submit">Search</button>
            </form>
            </div>
          </div>
          <div class="d-flex">
            <img src={placeholder} alt="" width="35" height="35" class="rounded-circle"></img>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default HomeMenu;