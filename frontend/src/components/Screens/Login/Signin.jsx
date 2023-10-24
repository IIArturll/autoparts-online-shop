import Header from '../../UI/Header/Header'
import Footer from '../../UI/Footer/Footer'
import SignInForm from '../../UI/SignInForm/SignInForm'

export default function Signin() {
	return (
		<div>
			<div className='wrapper'>
				<Header />
				<SignInForm />
				<Footer />
			</div>
		</div>
	)
}
