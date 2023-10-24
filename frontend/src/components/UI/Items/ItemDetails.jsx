import { Component } from 'react'

export class ItemDetails extends Component {
	render() {
		return (
			<div className='fullitem'>
				<div>
					<img
						src={'./img/' + this.props.item.img}
						onClick={() => this.props.onShowItem(this.props.item)}
					/>
					<h2>{this.props.item.name}</h2>
					<b>{this.props.item.price} $</b>
					<div
						className='add-to-cart'
						onClick={() => this.props.onAdd(this.props.item)}
					>
						+
					</div>
				</div>
			</div>
		)
	}
}

export default ItemDetails
