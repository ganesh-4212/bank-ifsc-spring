package com.ganesh.bankifsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.bankifsc.dto.AuthRequestBodyDto;
import com.ganesh.bankifsc.dto.AuthResponseBodyDto;
import com.ganesh.bankifsc.security.JwtTokenUtil;

@RestController
@CrossOrigin
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * @apiVersion 1.0.0
	 * @api {get} /authenticate Authenticate user by username and password.
	 * @apiName GetAuthTokenByUserCredentals
	 * @apiGroup Authentication
	 * @apiParam {Object} AuthRequestBodyDto User credentials.
	 * @apiParam {String} AuthRequestBodyDto.username Username of the user
	 * @apiParam {String} AuthRequestBodyDto.password Password of the user
	 * 
	 * @apiSuccess {Object} AuthResponseBodyDto Authentication response.
	 * @apiSuccess {String} AuthResponseBodyDto.token JWT token.
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequestBodyDto authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponseBodyDto(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
