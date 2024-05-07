package com.student.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.entity.UserInfo;
import com.student.repository.UserInfoRepo;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoRepo userInfoRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	public UserInfo registration(UserInfo userInfo) {
		String passEncode = passwordEncoder.encode(userInfo.getPassword());
		userInfo.setPassword(passEncode);
		UserInfo saveUser = userInfoRepo.save(userInfo);
		return saveUser;
	}
	

}
