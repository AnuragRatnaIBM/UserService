package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserServiceImpl userService;
    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }
   @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user)
    {
        User saveUser =userService.saveUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser()
    {
        return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id)
    {
        return new ResponseEntity<User>(userService.getUser(id),HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable int id)
    {
       userService.deleteUser(id);
       return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user)
    {
        return new ResponseEntity<User>(userService.updateUser(id, user),HttpStatus.OK);
    }

}
