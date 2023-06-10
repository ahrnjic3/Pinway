import API from "./api";

export const getCollection = async (id) => {
  const response = await API.get(`/api/collections/${id}`, { headers: { Authorization: `Bearer ${localStorage.getItem('Bearer')}` } });
  return response.data;
};

export const getPostsForCollection = async (id) => {
  const response = await API.get(`/api/collections/${id}/posts`, { headers: { Authorization: `Bearer ${localStorage.getItem('Bearer')}` } }); 
  return response.data;
};

export const deleteCollection = async (id) => {
    console.log("Id je: ", id)
    const response = await API.delete(`/api/collections/${id}`, { headers: { Authorization: `Bearer ${localStorage.getItem('Bearer')}` } });
    return response.data;
}
