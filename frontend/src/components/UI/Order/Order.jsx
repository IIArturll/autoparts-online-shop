/* eslint-disable react/prop-types */
import { Component } from 'react'
import { FaTrash } from 'react-icons/fa'
import styles from './Order.module.css'

export class Order extends Component {
	render() {
		return (
			<div className={styles.item}>
				<img src={'./img/' + this.props.item.img} />
				<h2>{this.props.item.name}</h2>
				<b>{this.props.item.price} $</b>
				<FaTrash
					className={styles.deleteItem}
					onClick={() => this.props.onDelete(this.props.item.id)}
				/>
			</div>
		)
	}
}

export default Order
