package com.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {
	
	Optional<UserInfo>findByEmail(String email);

}
