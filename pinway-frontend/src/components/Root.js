import React from "react";
import {
  BrowserRouter as Router, Routes, Route, Navigate,
} from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import HomeMenu from "components/HomeMenu";
import Collections from "./Collections/Collections";

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
        <Route path="/" element={<Navigate to="/collections" />} />
        <Route path="/collections" element={<Collections />} />
      </Routes> 
    </Router>
  </div>
);

export default Root;