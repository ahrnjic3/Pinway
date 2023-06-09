import React from 'react';
import './AccessForms.css';
import Logo from 'images/pinway_logo.png';

class LogIn extends React.Component {

    render() {
        return <div>

            <div className='form-container'>

                <div className='form-content-left'>
                    <form className='form' noValidate>
                         <div> <img class="image" src={Logo} alt="Pinway logo"></img></div>
                        <h3>Please Log In</h3>
                        <div className='form-inputs'>
                            <label className='form-label'>Username</label>
                            <input
                                className='form-input'
                                type='text'
                                name='username'
                                placeholder='Enter your username'

                            />
                        </div>
                        <div className='form-inputs'>
                            <label className='form-label'>Password</label>
                            <input
                                className='form-input'
                                type='password'
                                name='password'
                                placeholder='Enter your password'

                            />
                        </div>
                        <button className="button-login" type='submit'>
                            Log In
                        </button>
                        <span className='form-input-login'>
                            Don't have an account? Sign up <a href='./registration'>here</a>
                        </span>
                    </form>
                </div>
            </div>
        </div>;
    }
}

export default LogIn;

