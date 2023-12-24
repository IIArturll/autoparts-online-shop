import Alert from '@mui/material/Alert';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Footer, Navbar } from '../components';
const CustomAlert = ({ message, onClose }) => {
	return (
		<div
			style={{
				border: '1px solid #ccc',
				padding: '10px',
				marginBottom: '10px',
				backgroundColor: '#f8d7da',
				color: '#721c24',
			}}
		>
			<strong>Error:</strong> {message}
			<button onClick={onClose} style={{ marginLeft: '10px' }}>
				Close
			</button>
		</div>
	);
};

const Login = () => {
	const [showError, setShowError] = useState(false);
	const navigate = useNavigate();
	const [email, setEmail] = useState('');
	const [password, setPassword] = useState('');

	const handleLogin = async e => {
		e.preventDefault();

		console.log(
			JSON.stringify({
				email,
				password,
			})
		);

		const response = await fetch('http://localhost:3322/api/v1/user/login', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				email,
				password,
			}),
		});

		if (response.status === 200) {
			const data = await response.json();
			localStorage.setItem('authToken', 'mock_authToken');
			setShowError(false);
			navigate('/');
		} else {
			setShowError(true);
		}
	};

	const closeErrorAlert = () => {
		setShowError(false);
	};

	return (
		<>
			<Navbar />
			<div className='container my-3 py-3'>
				<h1 className='text-center'>Логин</h1>
				<hr />
				<div class='row my-4 h-100'>
					<div className='col-md-4 col-lg-4 col-sm-8 mx-auto'>
						<form onSubmit={handleLogin}>
							<div className='my-3'>
								<label htmlFor='floatingInput'>Email</label>
								<input
									type='email'
									className='form-control'
									id='floatingInput'
									placeholder='name@example.com'
									value={email}
									onChange={e => setEmail(e.target.value)}
								/>
							</div>
							<div className='my-3'>
								<label htmlFor='floatingPassword'>Пароль</label>
								<input
									type='password'
									className='form-control'
									id='floatingPassword'
									placeholder='Ваш пароль'
									value={password}
									onChange={e => setPassword(e.target.value)}
								/>
							</div>
							{showError && (
								<Alert severity='error'>Проверьте введённые данные!</Alert>
							)}
							<div className='my-3'>
								<p>
									Впервые здесь?{' '}
									<Link
										to='/register'
										className='text-decoration-underline text-info'
									>
										Регистрация
									</Link>{' '}
								</p>
							</div>
							<div className='text-center'>
								<button className='my-2 mx-auto btn btn-dark' type='submit'>
									Вход
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

export default Login;
