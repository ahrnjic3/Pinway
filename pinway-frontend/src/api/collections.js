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
    const response = await API.delete(`/api/collections/${id}`, { headers: { Authorization: `Bearer ${localStorage.getItem('Bearer')}` } });
    return response.data;
}

export const postCollection = async (data) => {
  const response = await API.post(`/api/collections`, data ,{ headers: { Authorization: `Bearer ${localStorage.getItem('Bearer')}` } });
  return response.data;
}
