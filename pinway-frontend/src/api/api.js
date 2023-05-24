import axios from "axios";

const API = axios.create({
    // url na apigateway
  baseURL: "http://localhost:3001",
});

export default API;