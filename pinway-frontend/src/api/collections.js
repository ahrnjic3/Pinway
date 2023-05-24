import API from "./api";

export const getCollections = async (params) => {
  const response = await API.get("/api/collections", { params });
  return response.data;
};
