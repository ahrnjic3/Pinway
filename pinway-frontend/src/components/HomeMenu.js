import React, { useState } from "react";
import { Menu, Dropdown } from "semantic-ui-react";
import'./App.css';
import pinway_logo from "images/pinway_logo.png";
import placeholder from  "images/place_holder.png";



const HomeMenu = () => {
  const [state, setState] = useState({ activeItem: "patients" });

  const handleItemClick = (e, { name }) => {
    setState({ activeItem: name });
  };

  const { activeItem } = state;

  return (

<nav style={{backgroundColor: '#d7a8f5', padding: '5px'}} className="navbar navbar-expand-lg">
  <a className="navbar-brand" href="/#">
      <img src={pinway_logo} alt="" width="132" height="32" className="d-inline-block align-text-top"></img>
   </a>
<button style={{paddingRight: '10px'}} type="button" className="btn btn-outline-secondary pr-3">New</button>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-4" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbar-list-4">
    <ul class="navbar-nav">
        <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle='dropdown' aria-haspopup="true" aria-expanded="false">
          <img src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg" width="40" height="40" class="rounded-circle"/>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="./collection">My Collections</a>
          <a class="dropdown-item" href="./user">My Profile</a>
          <a class="dropdown-item" href="#">Log Out</a>
        </div>
      </li>
    </ul>
  </div>
</nav>

);
}

export default HomeMenu;