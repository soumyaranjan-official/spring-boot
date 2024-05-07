package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.JWT.JwtService;
import com.student.JWT.TokenRespone;
import com.student.entity.UserInfo;
import com.student.payload.LoginRequest;
import com.student.serviceImpl.UserInfoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
    
	@Autowired
	private JwtService jwtService;
	
	
	@PostMapping("/signin")
	public ResponseEntity<UserInfo>registration(@Valid @RequestBody UserInfo userInfo){
		UserInfo registration = userInfoService.registration(userInfo);
		return new ResponseEntity<>(registration, HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/login")
	public TokenRespone authentication(@RequestBody LoginRequest authRequest) {
		
	Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
        	 return TokenRespone.builder()
        	            .accessToken(jwtService.generateToken(authRequest.getUsername())).build();
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
       
	}
	
//	
//	@PostMapping("/login")
//	public JwtResponse authenticationAndgetToken(@RequestBody AuthRequest authRequest) {
//		
//		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
//        if (authentication.isAuthenticated()) {
//        	RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequest.getName());
//           return JwtResponse.builder()
//            .accessToken(jwtService.generateToken(authRequest.getName()))
//            .token(refreshToken.getToken()).build();
//           
//        } else {
//            throw new UsernameNotFoundException("invalid user request !");
//        }
//	}

}

