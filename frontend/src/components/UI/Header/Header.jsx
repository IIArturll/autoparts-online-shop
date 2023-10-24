/* eslint-disable react/prop-types */
import { useState } from 'react'
import styles from './Header.module.css'
import { FaShoppingCart } from 'react-icons/fa'
import Order from '../Order/Order'

const showOrders = props => {
	let summa = 0
	props.orders.forEach(element => (summa += Number.parseFloat(element.price)))
	return (
		<div>
			{props.orders.map(el => (
				<Order key={el.id} item={el} onDelete={props.onDelete} />
			))}
			<p className={styles.sum}>
				Сумма заказа: {new Intl.NumberFormat().format(summa)}$
			</p>
		</div>
	)
}

const showEmpty = () => {
	return (
		<div className={styles.empty}>
			<h2>Товаров в корзине нет </h2>
		</div>
	)
}

export default function Header(props) {
	let [cartOpen, setCartOpen] = useState(false)

	return (
		<header>
			<div>
				<span className={styles.logo}>
					<a href='/'>Car-parts Sellers Shop</a>
				</span>
				<ul className={styles.nav}>
					<li>
						<a href='/'>Catalog</a>
					</li>
					<li>
						<a href='/sign-in'>Sign in</a>
					</li>
					<li>About us</li>
				</ul>
				<FaShoppingCart
					onClick={() => setCartOpen((cartOpen = !cartOpen))}
					className={`shop-cart-button ${cartOpen && 'active'}`}
				/>

				{cartOpen && (
					<div className={styles.cart}>
						{props.orders.length > 0 ? showOrders(props) : showEmpty()}
					</div>
				)}
			</div>
		</header>
	)
}
