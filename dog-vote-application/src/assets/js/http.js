import axios from "axios";
export default axios.create({
  baseURL: "http://localhost:8081/api/dogs/",
  headers: {
    "Content-Type": "application/json;charset=utf-8",
  },
});
