import React, { useEffect, useState } from "react";
import './EditProfile.css';
import currentPhotoURL from 'images/place_holder.png';
import { getUserById, updateUser, addUserPhoto} from "api/users";

const EditProfile = () => {

  const [files, setFiles] = useState(null);
  //state for checking file size
  const [fileSize, setFileSize] = useState(true);
  // for file upload progress message
  const [fileUploadProgress, setFileUploadProgress] = useState(false);
  //for displaying response message
  const [fileUploadResponse, setFileUploadResponse] = useState(null);

  const [username, setUsername] = useState('');
  const [name, setName] = useState('');
  const [surname, setSurname] = useState('');
  const [user, setUSer] = useState('');

  const uploadFileHandler = (event) => {
    setFiles(event.target.files);
   };

  const handleUpdateUSer = () =>{
     const data = {
      name: name,
      surname: surname,
      username: username,
      email: user.email,
      password: user.password,
      userVisibilityType:{
          id:1,
          type: "PUBLIC"
      },
      following:[],
      followers:[],
      numOfFollowing:0,
      numOfFollowers:0,
      userCollections:[]
  }
    updateUser(user.id, data);
    if(files != null){
      addUserPhoto(files,{
        "id":user.id
      })
    }
  }

   const handleUsernameChange = (e) => setUsername(e.target.value);
   const handleNameChange = (e) => setName(e.target.value);
   const handleSurnameChange = (e) => setSurname(e.target.value);

   useEffect(() => {
    const fetch = async () => {
      try {
        const response = await getUserById(localStorage.getItem("UserId"));
        setUSer(response);
        setName(response. name)
        setUsername(response.username)
        setSurname(response.surname)
      }catch (e) {
        //setError("Unable to fetch collections for user!");
      } finally {
        //setLoading(false);
      }
    };
    fetch();
      
  }, []);

  return (
   <div className="container w-75">
       <h2 className='section-title m-4'>Edit Profile</h2>
       <div className="col-10 mx-auto">
        <div className="row">
          <div className="col-4">
            <img className="rounded-circle  img-responsive" src={"https://i.pinimg.com/564x/84/3a/13/843a13b38250110cc297af7862343a01.jpg" } alt='currentPhotoURL' style={{borderRadius:"50%", width:"200px", height:"200px",objectFit:"cover"}} />
          </div>
          <div className="col-8">
            <div className="mt-2 container ">
              <form className="rounded pt-5 d-flex align-items-center flex-column" style={{background: 'white'}}>
                  <figure className="text-center" style={{color: 'grey'}}>
                    <blockquote className="blockquote">
                      <p>Change Photo</p>
                    </blockquote>
                  </figure>
                <div className="container rounded  w-75" >
                  <input className="form-control" type="file" onChange={uploadFileHandler} id="formFile"  style={{background: '#d7a8f5 100%', color: 'grey'}}/>
                </div>
                {!fileSize && <p style={{color:'red'}}>File size exceeded!!</p>}
                {fileUploadProgress && <p style={{color:'red'}}>Uploading File(s)</p>}
                {fileUploadResponse!=null && <p style={{color:'green'}}>{fileUploadResponse}</p>}
              </form>
            </div>
          </div>
       </div>

      </div>
       <div className='form-group'>
         <label htmlFor='username'>Username</label>
         <input
           className='form-control'
           type='text'
           id='username'
           name='username'
           placeholder= {user.username}
           value={username}
           onChange = {handleUsernameChange}
         />
       </div>

       <div className='form-group'>
         <label htmlFor='name'>Name</label>
         <input
           className='form-control'
           type='text'
           id='name'
           name='name'
           placeholder= {user.name}
           value={name}
           onChange = {handleNameChange}
         />
       </div>

       <div className='form-group'>
         <label htmlFor='email'>Surname</label>
         <input
           className='form-control'
           type='text'
           id='surname'
           name='surname'
           placeholder={user.surname}
           value={surname}
           onChange = {handleSurnameChange}
         />
       </div>


      <div className="row">
        <div className="offset-10 col-2">
          <button className='btn btn-blk w-100' style={{background: '#d7a8f5 100%'}} onClick={handleUpdateUSer}>Save Profile</button>
        </div>
      </div>
   </div>

  );
};

export default EditProfile;
