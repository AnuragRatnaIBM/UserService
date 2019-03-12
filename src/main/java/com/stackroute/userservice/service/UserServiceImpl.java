package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {

    //    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user)
    {
        User savedUser=userRepository.save(user);
        return savedUser;
    }
    public List<User> getAllUser()
    {
        List<User> userList=(List<User>) userRepository.findAll();
        return userList;

    }
    public User getUser(int id)
    {
        return userRepository.findById(id).get();
    }

    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }

    public User updateUser(int id,User user)
    {
        User localUser=userRepository.findById(id).get();
        localUser.setAge(user.getAge());
        return userRepository.save(localUser);
    }
}
