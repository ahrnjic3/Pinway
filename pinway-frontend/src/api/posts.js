import API from "./api";

export const addPost = async (image, data) => {
    console.log(image)
    console.log(data)
    const form = new FormData();
    form.append('postDTO', JSON.stringify(data));
    form.append('image', image[0]);

    const response = await API.post(`/api/post/add`,
    form,
    { headers: { Authorization: `Bearer ${localStorage.getItem('Bearer')}`, 'Content-Type' : `multipart/form-data`  } });
    return response.data;
}
