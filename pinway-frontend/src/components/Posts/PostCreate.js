import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

import { addPost } from 'api/posts';
import { getCollectionsForUser, addPostToCollection } from 'api/collections';

const params = {
  id: 2
}

const PostCreate = () => {

    const [files, setFiles] = useState('');
    //state for checking file size
    const [fileSize, setFileSize] = useState(true);
    // for file upload progress message
    const [fileUploadProgress, setFileUploadProgress] = useState(false);
    //for displaying response message
    const [fileUploadResponse, setFileUploadResponse] = useState(null);

    const [title, setTitle] = useState('')
    const [description, setDescription] = useState('')
    const [hashtags, setHashtags] = useState('')
    const [postString, setPostString] = useState({})
    const [userCollections, setUserCollections] = useState()
    const [collection, setCollection] = useState()
    const [selectedCollectionName, setSelectedCollectionName] = useState()
    //base end point url

    const navigate = useNavigate();

    const handleFileUpload = async (e) => {
        e.preventDefault()
        
        try {
          const response = await addPost(
            files,
            {
                title : title,
                description : description,
                image_path : '',
                hashtagNames: hashtags.split(/\s+/).filter(substring => substring !== ""),
                id: 1,
                user_id: localStorage.getItem("UserId")
                })
          const response2 = await addPostToCollection(collection, {"postId": response.id, actionUserId: localStorage.getItem("UserId")} )
          toast.success("Post created!");
          navigate("/users/details");
        } catch (err) {
          toast.error("Post creation failed!");
          console.log(postString)
        }
      };

    const uploadFileHandler = (event) => {
        setFiles(event.target.files);
       };

    useEffect(() => {
      setTitle("Title");
      setDescription("Decription");
      setHashtags([""]);

      const fetch = async () => {
        try {
          const response = await getCollectionsForUser(localStorage.getItem("UserId"));
          setUserCollections(response);
          if(userCollections.length > 0){
            setCollection(userCollections[0].id)
            setSelectedCollectionName(userCollections[0].name)
          }
        }catch (e) {
          setHashtags([]);
          //setError("Unable to fetch collections for user!");
        } finally {
          //setLoading(false);
          console.log("state " + userCollections)
        }
      };
      fetch();
        
    }, [params.id]);

    const handleTitleChange = (e) => setTitle(e.target.value);
    const handleDescriptionChange = (e) => setDescription(e.target.value);
    const handleHashtagChange = (e) => { setHashtags(e.target.value);}
    const handleCollectionItemClick = (item) => {
      setCollection(item.id)
      setSelectedCollectionName(item.name)
    }

    return (
      <div className="container rounded row mx-auto my-5 px-2 py-3"  style={{background: '#d7a8f5 100%', width: '50%'}}>
        {userCollections && (
          <div>
            <div className="row">
              <div className="col-6">
                <div className="mt-2 container ">
                  <form className="rounded pt-5 d-flex align-items-center flex-column" style={{background: 'white', height: '600px'}}>
                        <figure className="text-center" style={{color: 'grey'}}>
                          <blockquote className="blockquote">
                            <p>Add the image you</p>
                            <p>with to post</p>
                          </blockquote>
                        </figure>
                      <div className="container rounded mt-auto mb-4 w-75" >
                        <input className="form-control" type="file" onChange={uploadFileHandler} id="formFile"  style={{background: '#d7a8f5 100%', color: 'grey'}}/>
                      </div>
                      {!fileSize && <p style={{color:'red'}}>File size exceeded!!</p>}
                      {fileUploadProgress && <p style={{color:'red'}}>Uploading File(s)</p>}
                      {fileUploadResponse!=null && <p style={{color:'green'}}>{fileUploadResponse}</p>}
                  </form>
                </div>
              </div>
              <div className="col-6 rounded pt-4 d-flex align-items-center flex-column">
                <div className="row w-100">
                  <div className='form-group w-100'>
                    <label className='form-label rounded' style={{fontSize:20}} >Title</label>
                    <input
                        className='form-control'
                        type='text'
                        name='title'
                        value = {title}
                        placeholder='Title'
                        onChange = {handleTitleChange}
                    />
                  </div>
                </div>
                <div className="row w-100">
                  <div className="form-group">
                      <label htmlFor="textDesc" style={{color: "white", fontSize:20}}>Description</label>
                      <textarea className="form-control" id="textDesc"  onChange = {handleDescriptionChange} rows="3"></textarea>
                    </div>
                  </div>
                <div className="row w-100 mt-4">
                  <div className='form-group col-9'>
                      <input
                          className='form-control'
                          type='text'
                          name='collection'
                          value = {selectedCollectionName}
                          placeholder='Collection'
                          disabled
                      />
                  </div>

                  <div className="dropdown col-3">
                    <button className="btn btn-light text-secondary mb-1 btn dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                      Share
                    </button>
                    <div className="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton">
                      {userCollections.map((collection) => (
                        <button
                          key={collection.id}
                          className="dropdown-item"
                          type="button"
                          onClick={() => handleCollectionItemClick(collection)}
                        >
                          {`${collection.name}`}
                        </button>
                      ))}
                    </div>
                  </div>
                </div>

                <div className='form-inputs rounded mt-auto '>
                    <div className="form-group">
                      <label htmlFor="exampleFormControlTextarea1" style={{color: "white", fontSize:20}}>Hashtags</label>
                      <textarea className="form-control" id="exampleFormControlTextarea1"  onChange = {handleHashtagChange} rows="3"></textarea>
                    </div>
                </div>
              </div>
            </div>
            <div className="row">
              <div className="offset-10 col-2 mt-2">
                <button className="btn btn-light btn-blk w-100" onClick={handleFileUpload}>Upload</button>
              </div>
            </div>
          </div>
        )}
      </div>
    )
};

export default PostCreate;