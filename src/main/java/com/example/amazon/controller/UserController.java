package com.example.amazon.controller;

import com.example.amazon.model.Login;
import com.example.amazon.model.User;
import com.example.amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return service.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Login login){
        return service.login(login);
    }

    @PutMapping("/update")
    public String update(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return service.deleteUser(id);
    }
}
