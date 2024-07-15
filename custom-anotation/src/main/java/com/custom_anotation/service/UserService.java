package com.custom_anotation.service;

import com.custom_anotation.entity.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public void deleteUser(Integer u_Id);
    public User updateUser(User user, Integer u_Id);
    public User getUser(Integer u_Id);
    public List<User> getAllUsers();
}
