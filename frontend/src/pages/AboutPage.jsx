import React from 'react';
import { Footer, Navbar } from '../components';
const AboutPage = () => {
	return (
		<>
			<Navbar />
			<div className='container my-3 py-3'>
				<h1 className='text-center'>О нас</h1>
				<hr />
				<p className='lead text-center'>
					Добро пожаловать в наш магазин автозапчастей – ваш надежный партнер в
					мире автомобильных решений! Мы предоставляем широкий ассортимент
					высококачественных запчастей для различных марок и моделей. Наша
					миссия – обеспечить вас надежными и эффективными решениями для
					обслуживания и ремонта вашего автомобиля. Мы гордимся своей командой
					экспертов, готовых предоставить вам профессиональные консультации и
					помощь в выборе оптимальных деталей. В нашем магазине мы ценим каждого
					клиента и стремимся предоставить первоклассное обслуживание.
					Гарантируем высокое качество наших товаров и конкурентоспособные цены.
					Благодарим вас за выбор нас. Вместе мы создадим надежное и долговечное
					будущее для вашего автомобиля. Доверьтесь нам – мы заботимся о вашем
					автомобиле так, как будто это наш собственный!
				</p>

				<h2 className='text-center py-4'>Наши товары</h2>
				<div className='row'>
					<div className='col-md-3 col-sm-6 mb-3 px-3'>
						<div className='card h-100'>
							<img
								className='card-img-top img-fluid'
								src='/форсунок.jpg'
								alt=''
								height={160}
							/>
							<div className='card-body'>
								<h5 className='card-title text-center'>Форсунки</h5>
							</div>
						</div>
					</div>
					<div className='col-md-3 col-sm-6 mb-3 px-3'>
						<div className='card h-100'>
							<img
								className='card-img-top img-fluid'
								src='/колодка.jpg'
								alt=''
								height={160}
							/>
							<div className='card-body'>
								<h5 className='card-title text-center'>Тормозные колодки</h5>
							</div>
						</div>
					</div>
					<div className='col-md-3 col-sm-6 mb-3 px-3'>
						<div className='card h-100'>
							<img
								className='card-img-top img-fluid'
								src='/насос.jpg'
								alt=''
								height={160}
							/>
							<div className='card-body'>
								<h5 className='card-title text-center'>Топливные насосы</h5>
							</div>
						</div>
					</div>
					<div className='col-md-3 col-sm-6 mb-3 px-3'>
						<div className='card h-100'>
							<img
								className='card-img-top img-fluid'
								src='/датчик.jpg'
								alt=''
								height={160}
							/>
							<div className='card-body'>
								<h5 className='card-title text-center'>Датчики</h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			<Footer />
		</>
	);
};

export default AboutPage;
