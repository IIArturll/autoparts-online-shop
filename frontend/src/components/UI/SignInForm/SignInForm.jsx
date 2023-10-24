import React, { Component } from 'react'
import styles from './SignInForm.module.css'
import Button from '@mui/material/Button'
import Box from '@mui/material/Box'
import TextField from '@mui/material/TextField'

export class SignInForm extends Component {
	render() {
		return (
			<div className={styles.centeredContainer}>
				<div className={styles.form}>
					<h1>Welcome</h1>
					<form>
						<Box
							component='form'
							sx={{
								'& > :not(style)': { m: 2, width: '20ch' },
							}}
							noValidate
							autoComplete='off'
						>
							<div>
								<TextField
									id='outlined-basic'
									label='Username'
									variant='outlined'
								/>
							</div>
							<div>
								<TextField
									id='outlined-basic'
									label='Password'
									variant='outlined'
									type='password'
									autoComplete='current-password'
								/>
							</div>
						</Box>
						<div className={styles.button_container}>
							<Button variant='contained'>Sign in</Button>
						</div>
					</form>
				</div>
			</div>
		)
	}
}

export default SignInForm
