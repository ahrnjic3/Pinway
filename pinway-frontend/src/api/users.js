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
