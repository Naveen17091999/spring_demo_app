package com.example.amazon.service;

import com.example.amazon.model.Login;
import com.example.amazon.model.User;
import com.example.amazon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public String save(User user) {
//        List<User> list = repository.findAll();
//        for (User x : list) {
//            if (x.getEmail().equals(user.getEmail())) {
//                return "User exist";
//            }
//        }
//        repository.save(user);

        boolean isExist = repository.existsByEmail(user.getEmail());
        if(!isExist){
            repository.save(user);
            return "User saved.";
        }
        return "User exist";
    }

    public String login(Login login){
        Optional<User> isExists = repository.findByEmail(login.getEmail());
        if(isExists.isPresent()){
            if(isExists.get().getPassword().equals(login.getPassword())){
                return "Login success.";
            }
            return "Password misMatch.";
        }
        return "User does not exist.";
    }

    public String updateUser(User user){
        Optional<User> isExists = repository.findByEmail(user.getEmail());
        if(isExists.isPresent()){
            repository.save(user);
            return "User updated.";
        }
        return "User not exist";
    }

    public String deleteUser(int id){
        repository.deleteById(id);
        return "User removed.";
    }
}
