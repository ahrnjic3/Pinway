import React from "react";
import {
  BrowserRouter as Router, Routes, Route, Navigate,
} from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import HomeMenu from "components/HomeMenu";
import Collections from "./Collections/Collections";
import LogIn from "./Users/LogIn"
import Registration from "./Users/Registration"
import UserDetails from "components/Users/UserDetails"
import CollectionDelete from "./Collections/CollectionDelete";
import PostCreate from "./Posts/PostCreate";
import PostDetails from "./Posts/PostDetails";
import EditProfile from "./Users/EditProfile";

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
        <Route path="/addPost" element={<PostCreate/>} />
        <Route path="/postDetails" element={<PostDetails/>} />
        <Route path="/EditProfile" element={<EditProfile/>} />
      </Routes> 
    </Router>
  </div>
);

export default Root;