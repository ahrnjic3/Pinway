import { useState } from "react";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

import React from 'react';
import './AccessForms.css';
import Logo from 'images/pinway_logo.png';
import { login } from 'api/users';

const LogIn = () => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault()
        try {
          await login({username, password})
          .then(function (response) {
            localStorage.setItem("Bearer", response.accessToken);
            localStorage.setItem("UserId",response.id);
          });
          toast.success("Logged in!");
          navigate("/collections/");
        } catch (err) {
          toast.error("Login failed!");
          localStorage.setItem("Bearer", null);
        localStorage.setItem("UserId", 0);
        }
      };
    
    const handleUsernameChange = (e) => setUsername(e.target.value);
    const handlePasswordChange = (e) => setPassword(e.target.value);

    return (
    <div>
        <div className='form-container'>

            <div className='form-content-left rounded'>
                <form className='form' noValidate  onSubmit={handleLogin}>
                    <div> <img className="image mt-5" src={Logo} alt="Pinway logo"></img></div>
                    <h3>Welcome to Pinway</h3>
                    <div className='form-inputs'>
                        <label className='form-label'>Username</label>
                        <input
                            className='form-input'
                            type='text'
                            name='username'
                            value = {username}
                            placeholder='Enter your username'
                            onChange = {handleUsernameChange}

                        />
                    </div>
                    <div className='form-inputs'>
                        <label className='form-label rounded'>Password</label>
                        <input
                            className='form-input'
                            type='password'
                            name='password'
                            value = {password}
                            placeholder='Enter your password'
                            onChange = {handlePasswordChange}


                        />
                    </div>
                    <button className="button-login rounded" type='submit' onSubmit={handleLogin}>
                        Log In
                    </button>
                    <span className='form-input-login'>
                        Don't have an account? Sign up <a href='./registration'>here</a>
                    </span>
                </form>
            </div>
        </div>
    </div>
    )
}

export default LogIn;
