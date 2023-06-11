import React from 'react';
import '../style/EditProfile.css';
import currentPhotoURL from 'images/place_holder.png';

const EditProfile = () => {
  return (
   <div className='edit-profile-container'>
     <div className='edit-profile-form'>
       <h2 className='section-title'>Edit Profile</h2>
        <div className='photo-container'>
         <img className='current-photo' src={currentPhotoURL} alt='Current Profile' />
         <div className='photo-input'>
           <label htmlFor='photo'>Change Photo</label>
           <input
             type='file'
             id='photo'
             name='photo'
             accept='image/*'
           />
         </div>
       </div>
       <div className='form-group'>
         <label htmlFor='username'>Username</label>
         <input
           className='form-input'
           type='text'
           id='username'
           name='username'
           placeholder='Enter your username'
           value='User'
         />
       </div>

       <div className='form-group'>
         <label htmlFor='name'>Name</label>
         <input
           className='form-input'
           type='text'
           id='name'
           name='name'
           placeholder='Enter your name'
           value='User'
         />
       </div>

       <div className='form-group'>
         <label htmlFor='email'>Email</label>
         <input
           className='form-input'
           type='email'
           id='email'
           name='email'
           placeholder='Enter your email'
           value='user@etf.unsa.ba'
         />
       </div>



       <button className='btn-save'>Save Profile</button>
     </div>
   </div>

  );
};

export default EditProfile;
