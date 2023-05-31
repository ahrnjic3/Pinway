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

      <nav style={{backgroundColor: '#d7a8f5', padding: '5px'}} className="navbar navbar-expand-lg">
        <div className="container-fluid">
          <a className="navbar-brand" href="/#">
            <img src={pinway_logo} alt="" width="132" height="32" className="d-inline-block align-text-top"></img>
          </a>
          <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div className="navbar-nav">
            <button style={{paddingRight: '10px'}} type="button" className="btn btn-outline-secondary pr-3">New</button>
            {/* <form style={{paddingLeft: '5px'}} className="d-flex" role="search">
              <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"></input>
              <button className="btn btn-outline-secondary" type="submit">Search</button>
            </form> */}
            </div>
          </div>
          <div className="d-flex">
            <img src={placeholder} alt="" width="35" height="35" className="rounded-circle"></img>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default HomeMenu;