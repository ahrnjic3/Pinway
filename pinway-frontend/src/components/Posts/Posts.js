import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";


import { getPostsForCollection, deleteCollection } from "api/collections";
import Loader from "components/Loader";
import CollectionDelete from "components/Collections/CollectionDelete";

import placeholder from  "images/place_holder.png";
import { addPost } from 'api/posts';

const params = {
  id: 2
}

const Posts = () => {

    const [files, setFiles] = useState('');
    //state for checking file size
    const [fileSize, setFileSize] = useState(true);
    // for file upload progress message
    const [fileUploadProgress, setFileUploadProgress] = useState(false);
    //for displaying response message
    const [fileUploadResponse, setFileUploadResponse] = useState(null);

    const[title, setTitle] = useState('')
    const[description, setDescription] = useState('')
    const[hashtags, setHastags] = useState([])
    const[postString, setPostString] = useState({})
    //base end point url

    const navigate = useNavigate();

    const handleFileUpload = async (e) => {
        e.preventDefault()
        
        try {
          await addPost(
            files,
            {
                title : title,
                description : description,
                image_path : '',
                hashtagNames: hashtags,
                id: 1
                })
          .then(function (response) {
          });
          toast.success("Logged in!");
          navigate("/collections/");
        } catch (err) {
          toast.error("Login failed!");
          console.log(postString)
        }
      };

    const uploadFileHandler = (event) => {
        setFiles(event.target.files);
       };

    useEffect(() => {
        setTitle("naslov")
        setDescription("opis 123")
        setHastags(["noviHash"])
    }, [params.id]);

    const handleTitleChange = (e) => setTitle(e.target.value);
    const handleDescriptionChange = (e) => setDescription(e.target.value);

    return (
        <form onSubmit={handleFileUpload}>
            <input type="file" onChange={uploadFileHandler}/>
            <button type='submit'>Upload</button>
            {!fileSize && <p style={{color:'red'}}>File size exceeded!!</p>}
            {fileUploadProgress && <p style={{color:'red'}}>Uploading File(s)</p>}
            {fileUploadResponse!=null && <p style={{color:'green'}}>{fileUploadResponse}</p>}

            <div className='form-inputs'>
                        <label className='form-label'>Title</label>
                        <input
                            className='form-input'
                            type='text'
                            name='title'
                            value = {title}
                            placeholder='Title'
                            onChange = {handleTitleChange}

                        />
                    </div>
                    <div className='form-inputs'>
                        <label className='form-label rounded'>description</label>
                        <input
                            className='form-input'
                            type='text'
                            name='description'
                            value = {description}
                            placeholder='Description'
                            onChange = {handleDescriptionChange}
                        />
                    </div>
        </form>
    )
};

export default Posts;