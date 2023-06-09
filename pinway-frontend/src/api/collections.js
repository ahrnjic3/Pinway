import API from "./api";

export const getCollection = async (id) => {
  const response = await API.get(`/api/collections/${id}`, { headers: { Authorization: `Bearer eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjpbIlJPTEVfVVNFUiJdLCJzdWIiOiJlYmFzaWMiLCJpYXQiOjE2ODYzMzIyMTUsImV4cCI6MTY4NjY5MjIxNX0.sQuhchdEPaC-H1j1RzFyCtCNWyCjWTYOI0wF3yqBARjwjl4v4xAWGydWs-CulyjxPlLaZeHtZr-RQJU6R6F3Pw` } });
  return response.data;
};

export const getPostsForCollection = async (id) => {
  const response = await API.get(`/api/collections/${id}/posts`, { headers: { Authorization: `Bearer eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjpbIlJPTEVfVVNFUiJdLCJzdWIiOiJlYmFzaWMiLCJpYXQiOjE2ODYzMzIyMTUsImV4cCI6MTY4NjY5MjIxNX0.sQuhchdEPaC-H1j1RzFyCtCNWyCjWTYOI0wF3yqBARjwjl4v4xAWGydWs-CulyjxPlLaZeHtZr-RQJU6R6F3Pw` } }); 
  return response.data;
};

export const deleteCollection = async (id) => {
    console.log("Id je: ", id)
    const response = await API.delete(`/api/collections/${id}`, { headers: { Authorization: `Bearer eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjpbIlJPTEVfVVNFUiJdLCJzdWIiOiJlYmFzaWMiLCJpYXQiOjE2ODYzMzIyMTUsImV4cCI6MTY4NjY5MjIxNX0.sQuhchdEPaC-H1j1RzFyCtCNWyCjWTYOI0wF3yqBARjwjl4v4xAWGydWs-CulyjxPlLaZeHtZr-RQJU6R6F3Pw` } });
    return response.data;
}
