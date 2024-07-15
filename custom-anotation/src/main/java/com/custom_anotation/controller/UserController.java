package com.custom_anotation.controller;

import com.custom_anotation.entity.User;
import com.custom_anotation.repository.UserRepository;
import com.custom_anotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> addUser( @RequestBody User user){
        User addUser = userService.addUser(user);
        return new ResponseEntity<>(addUser, HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer u_Id){
        User userNotFound = userRepository.findById(u_Id).orElseThrow(() -> new RuntimeException("User not found"));
            if (userNotFound == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
                 userService.deleteUser(u_Id);
        return new ResponseEntity<> ("user deleted",HttpStatus.OK);

    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Integer u_Id){
        User userNotFound = userRepository.findById(u_Id).orElseThrow(() -> new RuntimeException("User not found"));
        if (userNotFound == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User updateUser = userService.updateUser(user, u_Id);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer u_Id){
        User userNotFound = userRepository.findById(u_Id).orElseThrow(() -> new RuntimeException("User not found"));
        if (userNotFound == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = userService.getUser(u_Id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>>getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
