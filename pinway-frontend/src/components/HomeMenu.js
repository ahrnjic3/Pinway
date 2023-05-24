import React, { useState } from "react";
import { Menu, Dropdown } from "semantic-ui-react";

const HomeMenu = () => {
  const [state, setState] = useState({ activeItem: "patients" });

  const handleItemClick = (e, { name }) => {
    setState({ activeItem: name });
  };

  const { activeItem } = state;

  return (
    <div class="container-fluid ml-3 bg-secondary">
      <p>Test</p>
    </div>
  );
};

export default HomeMenu;