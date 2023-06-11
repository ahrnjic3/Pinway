import React from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
  useLocation,
} from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import HomeMenu from "components/HomeMenu";
import Collections from "./Collections/Collections";
import LogIn from "./Users/LogIn";
import Registration from "./Users/Registration";
import UserDetails from "components/Users/UserDetails";
import UserProfile from "./Users/UserProfile";
import EditProfile from "./Users/EditProfile";

const Content = () => {
  const location = useLocation();

  // Check if the current route is '/registration'
  const isRegistrationPage = location.pathname.includes("/registration");
  const isLoginPage = location.pathname.includes("/login");
  return (
    <div>
      <ToastContainer
        position="top-center"
        autoClose={5000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
      />
      {!isRegistrationPage && !isLoginPage  && <HomeMenu />}

      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/collections" element={<Collections />} />
        <Route path="/users" element={<UserDetails />} />
        <Route path="/login" element={<LogIn />} />
        <Route path="/registration" element={<Registration />} />
        <Route path="/user" element={<UserProfile />} />
        <Route path="/edit" element={<EditProfile />} />

      </Routes>

    </div>
  );
};

const Root = () => (
  <Router>
    <Content />
  </Router>
);

export default Root;



/*import React from "react";
import {
  BrowserRouter as Router, Routes, Route, Navigate, useLocation
} from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import HomeMenu from "components/HomeMenu";
import Collections from "./Collections/Collections";
import LogIn from "./Users/LogIn"
import Registration from "./Users/Registration"
import UserDetails from "components/Users/UserDetails"
import UserProfile from "./Users/UserProfile"
const Root = () => (

  <div>
    <ToastContainer
      position="top-center"
      autoClose={5000}
      hideProgressBar={false}
      newestOnTop={false}
      closeOnClick
      rtl={false}
      pauseOnFocusLoss
      draggable
      pauseOnHover
    />
    <Router>
      <HomeMenu />

      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/collections" element={<Collections />} />
        <Route path="/users" element={<UserDetails/>} />
        <Route path="/login" element={<LogIn />} />
        <Route path="/registration" element={<Registration />} />
        <Route path="/user" element={<UserProfile />} />

      </Routes>
    </Router>
  </div>
);

export default Root;*/