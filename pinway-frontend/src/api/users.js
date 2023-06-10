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
  const response = await API.post(`/api/users/${id}/collection`, data, { headers: { Authorization: `Bearer ${localStorage.getItem('Bearer')}` } });
  //console.log(response.data);
  return response.data;
};
