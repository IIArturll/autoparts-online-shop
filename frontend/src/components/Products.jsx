import React, { useEffect, useState } from 'react';
import { useDispatch } from 'react-redux';
import { addCart } from '../redux/action';

import Skeleton from 'react-loading-skeleton';
import { useNavigate } from 'react-router-dom';

const Products = () => {
	const navigate = useNavigate();
	const [data, setData] = useState([]);
	const [filter, setFilter] = useState(data);
	const [loading, setLoading] = useState(false);
	let componentMounted = true;

	const dispatch = useDispatch();

	const addProduct = product => {
		dispatch(addCart(product));
	};

	useEffect(() => {
		const getProducts = async () => {
			setLoading(true);
			const response = await fetch('http://localhost:3322/api/v1/product');
			if (componentMounted) {
				setData(await response.clone().json());
				setFilter(await response.json());
				setLoading(false);
			}

			return () => {
				componentMounted = false;
			};
		};

		getProducts();
	}, []);

	const Loading = () => {
		return (
			<>
				<div className='col-12 py-5 text-center'>
					<Skeleton height={40} width={560} />
				</div>
				<div className='col-md-4 col-sm-6 col-xs-8 col-12 mb-4'>
					<Skeleton height={592} />
				</div>
				<div className='col-md-4 col-sm-6 col-xs-8 col-12 mb-4'>
					<Skeleton height={592} />
				</div>
				<div className='col-md-4 col-sm-6 col-xs-8 col-12 mb-4'>
					<Skeleton height={592} />
				</div>
				<div className='col-md-4 col-sm-6 col-xs-8 col-12 mb-4'>
					<Skeleton height={592} />
				</div>
				<div className='col-md-4 col-sm-6 col-xs-8 col-12 mb-4'>
					<Skeleton height={592} />
				</div>
				<div className='col-md-4 col-sm-6 col-xs-8 col-12 mb-4'>
					<Skeleton height={592} />
				</div>
			</>
		);
	};

	const filterProduct = cat => {
		const updatedList = data.filter(item => item.category === cat);
		setFilter(updatedList);
	};
	const ShowProducts = () => {
		return (
			<>
				<div className='buttons text-center py-5'>
					<button
						className='btn btn-outline-dark btn-sm m-2'
						onClick={() => setFilter(data)}
					>
						Все товары
					</button>
					<button
						className='btn btn-outline-dark btn-sm m-2'
						onClick={() => filterProduct('форсунки')}
					>
						Форсунки
					</button>
					<button
						className='btn btn-outline-dark btn-sm m-2'
						onClick={() => filterProduct('тормозные колодки')}
					>
						Тормозные колодки
					</button>
					<button
						className='btn btn-outline-dark btn-sm m-2'
						onClick={() => filterProduct('топливный насос')}
					>
						Топливный насос
					</button>
					<button
						className='btn btn-outline-dark btn-sm m-2'
						onClick={() => filterProduct('датчики')}
					>
						Датчики
					</button>
				</div>

				{filter.slice(0, 50).map(product => {
					return (
						<div
							id={product.id}
							key={product.id}
							className='col-md-4 col-sm-6 col-xs-8 col-12 mb-4'
						>
							<div className='card text-center h-100' key={product.id}>
								<img
									className='card-img-top p-3'
									src={product.image}
									alt='Card'
									height={300}
								/>
								<div className='card-body'>
									<h5 className='card-title'>{product.name}</h5>
									<p className='card-text'>
										{product.description.substring(0, 90)}...
									</p>
								</div>
								<ul className='list-group list-group-flush'>
									<li className='list-group-item lead'>$ {product.price}</li>
								</ul>
								<div className='card-body'>
									<button
										className='btn btn-dark m-1'
										onClick={() => {
											const authToken = localStorage.getItem('authToken');
											if (authToken) {
												addProduct(product);
											} else {
												navigate('/login');
											}
										}}
									>
										Добавить в корзину
									</button>
								</div>
							</div>
						</div>
					);
				})}
			</>
		);
	};
	return (
		<>
			<div className='container my-3 py-3'>
				<div className='row justify-content-center'>
					{loading ? <Loading /> : <ShowProducts />}
				</div>
			</div>
		</>
	);
};

export default Products;
