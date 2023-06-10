import API from "./api";

export const getCollectionsForUser = async (id) => {
  const response = await API.get(`/api/users/${id}/collection`);
  //const response = await API.get(`/api/users/${id}/collection`);
  return response.data;
};

export const login = async (data) => {
  const response = await API.post(`/api/signin/login`, data);
  return response.data;
};

export const getFollowersForUser = async (id) => {
  const response = await API.get(`/api/users/${id}/followers`);
  //console.log(response.data);
  return response.data;
};

export const addUserToCollection = async (id, {data}) => {
  const response = await API.post(`/api/users/${id}/collection`, data, { headers: { Authorization: `Bearer eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjpbIlJPTEVfVVNFUiJdLCJzdWIiOiJlYmFzaWMiLCJpYXQiOjE2ODYzMzIyMTUsImV4cCI6MTY4NjY5MjIxNX0.sQuhchdEPaC-H1j1RzFyCtCNWyCjWTYOI0wF3yqBARjwjl4v4xAWGydWs-CulyjxPlLaZeHtZr-RQJU6R6F3Pw` } });
  //console.log(response.data);
  return response.data;
};
