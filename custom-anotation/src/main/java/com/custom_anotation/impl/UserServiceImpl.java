package com.custom_anotation.impl;

import com.custom_anotation.dto.UserDto;
import com.custom_anotation.entity.User;
import com.custom_anotation.repository.UserRepository;
import com.custom_anotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserDto userDto;

    @Override
    public User addUser(User user) {
        User userData = User.build(0, userDto.getName(), userDto.getEmail(), userDto.getPassword(), userDto.getRole(), userDto.getStatus());
        return userRepository.save(userData);
    }

    @Override
    public void deleteUser(Integer u_Id) {

        Optional<User> id = userRepository.findById(u_Id);
        if (id.isPresent()) {
            userRepository.deleteById(u_Id);
        }

    }

    @Override
    public User updateUser(User user, Integer u_Id) {
        User user1 = userRepository.findById(u_Id).orElseThrow(() -> new RuntimeException("User not found"));
        user1.setName(userDto.getName());
        return userRepository.save(user1);

    }

    @Override
    public User getUser(Integer u_Id) {
        User user = userRepository.findById(u_Id).orElseThrow(() -> new RuntimeException("User not found"));

        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
