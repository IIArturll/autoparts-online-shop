import './App.css'
import React from 'react'
import Header from './components/UI/Header/Header'
import Footer from './components/UI/Footer/Footer'
import Items from './components/UI/Items/Items'
import Categories from './components/UI/Categories/Categories'
import ItemDetails from './components/UI/Items/ItemDetails'
import './index.css'
import Presentation from './components/UI/Header/Presentation'

class App extends React.Component {
	constructor(props) {
		super(props)
		this.state = {
			orders: [],
			items: [
				{
					id: '079f31f4-6eee-4127-88f0-f5cdf76716c6',
					title: 'hgjh',
					category: 'bagadge',
					brand: 'sdfdsfsd',
					description: 'asdasdsadas',
					price: 321.4,
					amount: 5,
				},
			],
			current_items: [],
			showFullItem: false,
			fullItem: {},
		}

		this.state.current_items = this.state.items
		this.addToOrder = this.addToOrder.bind(this)
		this.deleteOrder = this.deleteOrder.bind(this)
		this.chooseCategory = this.chooseCategory.bind(this)
		this.onShowItem = this.onShowItem.bind(this)
	}

	render() {
		return (
			<div className='wrapper'>
				<Header orders={this.state.orders} onDelete={this.deleteOrder} />
				<Presentation />
				<Categories chooseCategory={this.chooseCategory} />
				<Items
					items={this.state.current_items}
					onAdd={this.addToOrder}
					onShowItem={this.onShowItem}
				/>

				{this.state.showFullItem && (
					<ItemDetails
						item={this.state.fullItem}
						onAdd={this.addToOrder}
						onShowItem={this.onShowItem}
					/>
				)}
				<Footer />
			</div>
		)
	}

	onShowItem(item) {
		this.setState({
			fullItem: item,
		})
		this.setState({
			showFullItem: !this.state.showFullItem,
		})
	}

	chooseCategory(category) {
		if (category === 'all') {
			this.setState({
				current_items: this.state.items,
			})
			return
		}

		this.setState({
			current_items: this.state.items.filter(
				element => element.category === category
			),
		})
	}

	addToOrder(item) {
		let isInArray = false
		this.state.orders.forEach(element => {
			if (element.id === item.id) isInArray = true
		})

		if (!isInArray) this.setState({ orders: [...this.state.orders, item] })
	}

	deleteOrder(id) {
		this.setState({
			orders: this.state.orders.filter(element => element.id !== id),
		})
	}
}

export default App
