import API from "./api";

export const getCollection = async (id) => {
  const response = await API.get(`/api/collections/${id}`);
  return response.data;
};

export const getPostsForCollection = async (id) => {
  // console.log(id);
  const response = await API.get(`/api/collections/${id}/posts`);
  // console.log(response.data); 
  return response.data;
};
