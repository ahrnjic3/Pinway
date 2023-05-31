import axios from "axios";

const API = axios.create({
    // url na apigateway
  baseURL: "http://localhost:8083",
});

export default API;