import API from "./api";

export const getCollectionsForUser = async (id) => {
  const response = await API.get(`/api/users/${id}/collection`);
  return response.data;
};

export const getFollowersForUser = async (id) => {
  const response = await API.get(`/api/users/${id}/followers`);
  return response.data;
};