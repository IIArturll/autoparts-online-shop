import axios from 'axios';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Footer, Navbar } from '../components';

const Register = () => {
	const [email, setEmail] = useState('');
	const [password, setPassword] = useState('');
	const [firstname, setFirstname] = useState('');
	const [lastname, setLastname] = useState('');
	const [phone, setPhone] = useState('');

	const handleRegister = async e => {
		e.preventDefault();

		const postData = {
			email,
			password,
			firstname,
			lastname,
			phone,
		};

		console.log(postData);

		try {
			const response = await axios.post(
				'http://localhost:51662/api/v1/user',
				postData,
				{
					headers: {
						'Content-Type': 'application/json',
					},
					withCredentials: true,
				}
			);

			if (response.status === 201) {
				console.log('Success');
				console.log(response.data);
			} else {
				console.error('Request failed');
			}
		} catch (error) {
			console.error('Error during request', error);
		}
	};

	return (
		<>
			<Navbar />
			<div className='container my-3 py-3'>
				<h1 className='text-center'>Register</h1>
				<hr />
				<div class='row my-4 h-100'>
					<div className='col-md-4 col-lg-4 col-sm-8 mx-auto'>
						<form onSubmit={handleRegister}>
							<div class='form my-3'>
								<label for='Email'>Email address</label>
								<input
									type='email'
									class='form-control'
									id='Email'
									value={email}
									placeholder='name@example.com'
									onChange={e => setEmail(e.target.value)}
								/>
							</div>
							<div class='form  my-3'>
								<label for='Password'>Password</label>
								<input
									type='password'
									class='form-control'
									id='Password'
									value={password}
									placeholder='Password'
									onChange={e => setPassword(e.target.value)}
								/>
							</div>
							<div class='form my-3'>
								<label for='Firstname'>Firstname</label>
								<input
									type='name'
									class='form-control'
									id='Name'
									value={firstname}
									placeholder='Enter Your Firstname'
									onChange={e => setFirstname(e.target.value)}
								/>
							</div>
							<div class='form my-3'>
								<label for='Lastname'>Lastname</label>
								<input
									type='name'
									class='form-control'
									id='Lastname'
									value={lastname}
									placeholder='Enter Your Lastname'
									onChange={e => setLastname(e.target.value)}
								/>
							</div>
							<div class='form my-3'>
								<label for='Phone'>Phone</label>
								<input
									type='phone'
									class='form-control'
									id='Phone'
									value={phone}
									placeholder='Enter your phone'
									onChange={e => setPhone(e.target.value)}
								/>
							</div>
							<div className='my-3'>
								<p>
									Already has an account?{' '}
									<Link
										to='/login'
										className='text-decoration-underline text-info'
									>
										Login
									</Link>{' '}
								</p>
							</div>
							<div className='text-center'>
								<button class='my-2 mx-auto btn btn-dark' type='submit' enable>
									Register
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<Footer />
		</>
	);
};

export default Register;
