import API from "./api";

export const getCollection = async (id) => {
  const response = await API.get(`/api/collections/${id}`);
  return response.data;
};

export const getPostsForCollection = async (id) => {
  const response = await API.get(`/api/collections/${id}/posts`); 
  return response.data;
};

export const deleteCollection = async (id) => {
    console.log("Id je: ", id)
    const response = await API.delete(`/api/collections/${id}`);
    return response.data;
}
