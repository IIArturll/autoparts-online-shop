import React from 'react';

const Footer = () => {
	return (
		<>
			<footer className='mb-0 text-center'>
				<div className='d-flex align-items-center justify-content-center pb-5'>
					<div className='col-md-6'>
						<p className='mb-3 mb-md-0'>
							A. Шарамета | E. Максимчик |
							<a
								href='https://github.com/mosey20000/autoparts-online-shophttps://github.com/mosey20000/autoparts-online-shop'
								className='text-decoration-none text-dark fs-6'
								target='_blank'
								rel='noreferrer'
								style={{ paddingLeft: '3px' }}
							>
								150502
							</a>
						</p>
						<a
							className='text-dark fs-4'
							href='https://github.com/mosey20000/autoparts-online-shop'
							target='_blank'
							rel='noreferrer'
						>
							<i className='fa fa-github'></i>
						</a>
					</div>
				</div>
			</footer>
		</>
	);
};

export default Footer;
