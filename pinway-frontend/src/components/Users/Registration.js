import React, { useEffect, useState } from "react";
import './AccessForms.css';
import axios from 'axios';
import Logo from 'images/pinway_logo.png';
import { addUSer } from 'api/users';
import { useNavigate } from "react-router-dom";

import placeholder from  "images/place_holder.png";

function Registration(){

    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    async function save(event)
        {
        event.preventDefault();
        try
            {
                addUSer({
                    name: name,
                    surname: surname,
                    username: username,
                    email: email,
                    password: password,
                    userVisibilityType:{
                        id:1,
                        type: "PUBLIC"
                    },
                    following:[],
                    followers:[],
                    numOfFollowing:0,
                    numOfFollowers:0,
                    userCollections:[]
                })
            }
        catch(err)
            {
            alert("User Registration Failed");
            return;
            }
        finally{
            alert("User Registration Successfully");
            setName("");
            setSurname("");
            setUsername("");
            setEmail("");
            setPassword("");
            navigate("/login")
        }
   }


        return (
        <div>
            <div className='form-container mx-auto mt-4'>
                <div className='form-content-left rounded px-2'>
                        <h2> <img className="image image-contain w-100" src={Logo} alt="Pinway logo"></img></h2>
                        <h3>Please Sign Up</h3>

                        <div className='form-group'>
                            <input
                                className='form-control'
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

                        <div className='form-group'>
                        <label className='form-label'>Last name</label>
                            <input
                                className='form-control'
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

                        <div className='form-group'>
                        <label className='form-label'>Username</label>
                            <input
                                className='form-control'
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

                        <div className='form-group'>
                        <label className='form-label'>Email</label>
                            <input
                                className='form-control'
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

                        <div className='form-group'>
                            <label className='form-label'>Password</label>
                                <input
                                    className='form-control'
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
                        <div className="text-center">
                            <span  className='form-input-login mb-1' onClick={() => {navigate("/login")}}>
                                Already have created account? Login <a>here</a>
                            </span>
                        </div>

                </div>
            </div>
        </div>

    );
}

export default Registration;