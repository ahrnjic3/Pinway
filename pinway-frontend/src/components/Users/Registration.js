import React, { useEffect, useState } from "react";
import './AccessForms.css';
import axios from 'axios';
import {confirmAlert} from "react-confirm-alert";
import Logo from 'images/pinway_logo.png';

import placeholder from  "images/place_holder.png";

function Registration(){

    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    async function save(event)
        {
        event.preventDefault();
        try
            {
             await axios.post("http://localhost:8085/api/user/add",
            {

            name: name,
            surname : surname,
            username : username,
            password : password,
            email : email,
            visibility_type : "PRIVATE"

            });

                alert("User Registration Successfully");
                setName("");
                setSurname("");
                setUsername("");
                setEmail("");
                setPassword("");
            }
        catch(err)
            {
            alert("User Registration Failed");
            }
   }


        return (
        <div>
            <div className='form-container-register'>
                <div className='form-content-left'>
                        <h2> <img class="image image-contain" src={Logo} alt="Pinway logo"></img></h2>
                        <h3>Please Sign Up</h3>

                        <div className='form-inputs'>
                            <label className='form-label'>First name</label>
                            <input
                                className='form-input'
                                type='text'
                                name='name'
                                placeholder='Enter first name'
                                value={name}
                                onChange={(event) =>
                                    {
                                    setName(event.target.value);
                                    }}
                            />

                        </div>
                        <div className='form-inputs'>
                            <label className='form-label'>Last name</label>
                            <input
                                className='form-input'
                                type='text'
                                name='surname'
                                placeholder='Enter last name'
                                value={surname}
                                onChange={(event) =>
                                    {
                                        setSurname(event.target.value);
                                    }}

                            />
                        </div>
                        <div className='form-inputs'>
                            <label className='form-label'>Username</label>
                            <input
                                className='form-input'
                                type='text'
                                name='username'
                                placeholder='Enter your username'
                                value={username}
                                onChange={(event) =>
                                   {
                                       setUsername(event.target.value);
                                }}
                            />
                        </div>
                        <div className='form-inputs'>
                            <label className='form-label'>Email</label>
                            <input
                                className='form-input'
                                type='email'
                                name='email'
                                placeholder='Enter your email'
                                value={email}
                                onChange={(event) =>
                                   {
                                       setEmail(event.target.value);
                                   }}
                            />

                        </div>
                        <div className='form-inputs'>
                            <label className='form-label'>Password</label>
                            <input
                                className='form-input'
                                type='password'
                                name='password'
                                placeholder='Enter your password'
                                value={password}
                                onChange={(event) =>
                                  {
                                      setPassword(event.target.value);
                                  }}
                            />

                        </div>

                        <button className="button-login" onClick={save}>
                            Sign Up
                        </button>
                        <span style={{marginBottom: "10%"}} className='form-input-login'>
                            Already have created account? Login <a href='./login'>here</a>
                        </span>

                </div>
            </div>
        </div>

    );
}

export default Registration;