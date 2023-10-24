import { Component } from 'react'
import styles from './Categories.module.css'

export class Categories extends Component {
	constructor(props) {
		super(props)
		this.state = {
			categories: [
				{
					key: 'all',
					name: 'Все товары',
				},
				{
					key: 'engines',
					name: 'Двигатели',
				},
				{
					key: 'brakes',
					name: 'Тормоза',
				},
				{
					key: 'lamps',
					name: 'Фары',
				},
			],
		}
	}

	render() {
		return (
			<div className={styles.categories}>
				{this.state.categories.map(element => (
					<div
						key={element.key}
						onClick={() => this.props.chooseCategory(element.key)}
					>
						{element.name}
					</div>
				))}
			</div>
		)
	}
}

export default Categories
