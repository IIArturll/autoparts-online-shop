import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Footer, Navbar } from '../components';

const Login = () => {
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

		// const response = await fetch('url', {
		// 	method: 'POST',
		// 	headers: {
		// 		'Content-Type': 'application/json',
		// 	},
		// 	body: JSON.stringify({
		// 		email,
		// 		password,
		// 	}),
		// });

		// if (response.status === 200) {
		// 	const data = await response.json();
		// 	Cookies.set('bearerToken', data.token, { expires: 7 }); // You can adjust the expiration time as needed
		// } else {
		// 	console.error('Login failed');
		// }
	};

	return (
		<>
			<Navbar />
			<div className='container my-3 py-3'>
				<h1 className='text-center'>Login</h1>
				<hr />
				<div class='row my-4 h-100'>
					<div className='col-md-4 col-lg-4 col-sm-8 mx-auto'>
						<form onSubmit={handleLogin}>
							<div className='my-3'>
								<label htmlFor='floatingInput'>Email address</label>
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
								<label htmlFor='floatingPassword'>Password</label>
								<input
									type='password'
									className='form-control'
									id='floatingPassword'
									placeholder='Password'
									value={password}
									onChange={e => setPassword(e.target.value)}
								/>
							</div>
							<div className='my-3'>
								<p>
									New Here?{' '}
									<Link
										to='/register'
										className='text-decoration-underline text-info'
									>
										Register
									</Link>{' '}
								</p>
							</div>
							<div className='text-center'>
								<button className='my-2 mx-auto btn btn-dark' type='submit'>
									Login
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
