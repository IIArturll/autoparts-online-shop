import React from 'react';
import { useSelector } from 'react-redux';
import { NavLink } from 'react-router-dom';

const Navbar = () => {
	const state = useSelector(state => state.handleCart);
	const authToken = localStorage.getItem('authToken');
	const handleLogout = () => {
		localStorage.removeItem('authToken');
	};

	return (
		<nav className='navbar navbar-expand-lg navbar-light bg-light py-3 sticky-top'>
			<div className='container'>
				<NavLink className='navbar-brand fw-bold fs-4 px-2' to='/'>
					{' '}
					Car-parts eShop
				</NavLink>
				<button
					className='navbar-toggler mx-2'
					type='button'
					data-toggle='collapse'
					data-target='#navbarSupportedContent'
					aria-controls='navbarSupportedContent'
					aria-expanded='false'
					aria-label='Toggle navigation'
				>
					<span className='navbar-toggler-icon'></span>
				</button>

				<div className='collapse navbar-collapse' id='navbarSupportedContent'>
					<ul className='navbar-nav m-auto my-2 text-center'>
						<li className='nav-item'>
							<NavLink className='nav-link' to='/'>
								Главная страница{' '}
							</NavLink>
						</li>
						<li className='nav-item'>
							<NavLink className='nav-link' to='/product'>
								Товары
							</NavLink>
						</li>
						<li className='nav-item'>
							<NavLink className='nav-link' to='/about'>
								О нас
							</NavLink>
						</li>
						<li className='nav-item'>
							<NavLink className='nav-link' to='/contact'>
								Обратная связь
							</NavLink>
						</li>
					</ul>
					<div className='buttons text-center'>
						{!authToken && (
							<>
								<NavLink to='/login' className='btn btn-outline-dark m-2'>
									<i className='fa fa-sign-in-alt mr-1'></i> Вход
								</NavLink>
								<NavLink to='/register' className='btn btn-outline-dark m-2'>
									<i className='fa fa-user-plus mr-1'></i> Регистрация
								</NavLink>
							</>
						)}
						{authToken && (
							<>
								<NavLink to='/cart' className='btn btn-outline-dark m-2'>
									<i className='fa fa-cart-shopping mr-1'></i> Корзина
								</NavLink>
								<NavLink
									to='/product'
									className='btn btn-outline-dark m-2'
									onClick={handleLogout}
								>
									<i className='fa fa-user-plus mr-1'></i> Выйти
								</NavLink>
							</>
						)}
					</div>
				</div>
			</div>
		</nav>
	);
};

export default Navbar;
