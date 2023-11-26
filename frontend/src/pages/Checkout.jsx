import React from 'react';
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { Footer, Navbar } from '../components';
const Checkout = () => {
	const state = useSelector(state => state.handleCart);

	const EmptyCart = () => {
		return (
			<div className='container'>
				<div className='row'>
					<div className='col-md-12 py-5 bg-light text-center'>
						<h4 className='p-3 display-5'>Ваша корзина пустая</h4>
						<Link to='/' className='btn btn-outline-dark mx-4'>
							<i className='fa fa-arrow-left'></i> Вернуться к просмотру товаров
						</Link>
					</div>
				</div>
			</div>
		);
	};

	const ShowCheckout = () => {
		let subtotal = 0;
		let shipping = 30.0;
		let totalItems = 0;
		state.map(item => {
			return (subtotal += item.price * item.qty);
		});

		state.map(item => {
			return (totalItems += item.qty);
		});
		return (
			<>
				<div className='container py-5'>
					<div className='row my-4'>
						<div className='col-md-5 col-lg-4 order-md-last'>
							<div className='card mb-4'>
								<div className='card-header py-3 bg-light'>
									<h5 className='mb-0'>Общая стоимость заказа</h5>
								</div>
								<div className='card-body'>
									<ul className='list-group list-group-flush'>
										<li className='list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0'>
											Товары ({totalItems})<span>${Math.round(subtotal)}</span>
										</li>
										<li className='list-group-item d-flex justify-content-between align-items-center px-0'>
											Доставка
											<span>${shipping}</span>
										</li>
										<li className='list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3'>
											<div>
												<strong>Общая стоимость</strong>
											</div>
											<span>
												<strong>${Math.round(subtotal + shipping)}</strong>
											</span>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div className='col-md-7 col-lg-8'>
							<div className='card mb-4'>
								<div className='card-header py-3'>
									<h4 className='mb-0'>Адрес доставки</h4>
								</div>
								<div className='card-body'>
									<form className='needs-validation' novalidate>
										<div className='row g-3'>
											<div className='col-sm-6 my-1'>
												<label for='firstName' className='form-label'>
													Имя
												</label>
												<input
													type='text'
													className='form-control'
													id='firstName'
													placeholder=''
													required
												/>
												<div className='invalid-feedback'>
													Введите настоящие имя
												</div>
											</div>

											<div className='col-sm-6 my-1'>
												<label for='lastName' className='form-label'>
													Фамилия
												</label>
												<input
													type='text'
													className='form-control'
													id='lastName'
													placeholder=''
													required
												/>
												<div className='invalid-feedback'>
													Введите настоящую фамилию
												</div>
											</div>

											<div className='col-12 my-1'>
												<label for='email' className='form-label'>
													Email
												</label>
												<input
													type='email'
													className='form-control'
													id='email'
													placeholder='you@example.com'
													required
												/>
												<div className='invalid-feedback'>
													Введите правильный адрес электронной почты
												</div>
											</div>

											<div className='col-12 my-1'>
												<label for='address' className='form-label'>
													Адрес доставки
												</label>
												<input
													type='text'
													className='form-control'
													id='address'
													placeholder='1234 Main St'
													required
												/>
												<div className='invalid-feedback'>
													Введите адрес доставки
												</div>
											</div>

											<div className='col-md-5 my-1'>
												<label for='country' className='form-label'>
													Страна
												</label>
												<br />
												<select className='form-select' id='country' required>
													<option value=''>Выберите...</option>
													<option>Индия</option>
												</select>
												<div className='invalid-feedback'>
													Введите корректную страну
												</div>
											</div>

											<div className='col-md-4 my-1'>
												<label for='state' className='form-label'>
													Штат
												</label>
												<br />
												<select className='form-select' id='state' required>
													<option value=''>Выберите...</option>
													<option>Пунжаб</option>
												</select>
												<div className='invalid-feedback'>
													Выберите правильный штат
												</div>
											</div>

											<div className='col-md-3 my-1'>
												<label for='zip' className='form-label'>
													Индекс
												</label>
												<input
													type='text'
													className='form-control'
													id='zip'
													placeholder=''
													required
												/>
												<div className='invalid-feedback'>
													Введите правильный индекс
												</div>
											</div>
										</div>

										<hr className='my-4' />

										<h4 className='mb-3'>Оплата</h4>

										<div className='row gy-3'>
											<div className='col-md-6'>
												<label for='cc-name' className='form-label'>
													ФИО на карте
												</label>
												<input
													type='text'
													className='form-control'
													id='cc-name'
													placeholder=''
													required
												/>
												<small className='text-muted'>
													Полное имя указано на карте
												</small>
												<div className='invalid-feedback'>
													Введите имя с карты
												</div>
											</div>

											<div className='col-md-6'>
												<label for='cc-number' className='form-label'>
													Номер банковской карты
												</label>
												<input
													type='text'
													className='form-control'
													id='cc-number'
													placeholder=''
													required
												/>
												<div className='invalid-feedback'>
													Введите номер банковской карты
												</div>
											</div>

											<div className='col-md-3'>
												<label for='cc-expiration' className='form-label'>
													Срок действия
												</label>
												<input
													type='text'
													className='form-control'
													id='cc-expiration'
													placeholder=''
													required
												/>
												<div className='invalid-feedback'>
													Введите срок действия
												</div>
											</div>

											<div className='col-md-3'>
												<label for='cc-cvv' className='form-label'>
													СVV
												</label>
												<input
													type='text'
													className='form-control'
													id='cc-cvv'
													placeholder=''
													required
												/>
												<div className='invalid-feedback'>Введите ваш CVV</div>
											</div>
										</div>

										<hr className='my-4' />

										<button
											className='w-100 btn btn-primary '
											type='submit'
											disabled
										>
											Продолжить оплату
										</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</>
		);
	};
	return (
		<>
			<Navbar />
			<div className='container my-3 py-3'>
				<h1 className='text-center'>Оплата</h1>
				<hr />
				{state.length ? <ShowCheckout /> : <EmptyCart />}
			</div>
			<Footer />
		</>
	);
};

export default Checkout;
