import Alert from '@mui/material/Alert';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Footer, Navbar } from '../components';

const Register = () => {
	const navigate = useNavigate();
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
			const response = await fetch('http://localhost:3322/api/v1/user', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify(postData),
			});

			if (response.status === 201) {
				console.log('Success');
				localStorage.setItem('authToken', 'mock_authToken');
				navigate('/');
			} else {
				console.error('Request failed');
				return (
					<Alert severity='error'>This is an error alert — check it out!</Alert>
				);
			}
		} catch (error) {
			console.error('Error during request', error);
		}
	};

	return (
		<>
			<Navbar />
			<div className='container my-3 py-3'>
				<h1 className='text-center'>Регистрация</h1>
				<hr />
				<div class='row my-4 h-100'>
					<div className='col-md-4 col-lg-4 col-sm-8 mx-auto'>
						<form onSubmit={handleRegister}>
							<div class='form my-3'>
								<label for='Email'>Email</label>
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
								<label for='Password'>Пароль</label>
								<input
									type='password'
									class='form-control'
									id='Password'
									value={password}
									placeholder='Пароль'
									onChange={e => setPassword(e.target.value)}
								/>
							</div>
							<div class='form my-3'>
								<label for='Firstname'>Имя</label>
								<input
									type='name'
									class='form-control'
									id='Name'
									value={firstname}
									placeholder='Введите ваше имя'
									onChange={e => setFirstname(e.target.value)}
								/>
							</div>
							<div class='form my-3'>
								<label for='Lastname'>Фамилия</label>
								<input
									type='name'
									class='form-control'
									id='Lastname'
									value={lastname}
									placeholder='Введите вашу фамилию'
									onChange={e => setLastname(e.target.value)}
								/>
							</div>
							<div class='form my-3'>
								<label for='Phone'>Телефон</label>
								<input
									type='phone'
									class='form-control'
									id='Phone'
									value={phone}
									placeholder='Номер телефона'
									onChange={e => setPhone(e.target.value)}
								/>
							</div>
							<div className='my-3'>
								<p>
									Уже зарегистрированы?{' '}
									<Link
										to='/login'
										className='text-decoration-underline text-info'
									>
										Вход
									</Link>{' '}
								</p>
							</div>
							<div className='text-center'>
								<button class='my-2 mx-auto btn btn-dark' type='submit' enable>
									Регистрация
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
