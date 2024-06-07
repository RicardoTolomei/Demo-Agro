package com.demoagro.demoagro.controller;

import com.demoagro.demoagro.model.User;
import com.demoagro.demoagro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@SpringBootApplication

public class UserController {

    @Autowired
    private  UserService userService;




    @RequestMapping(value = "api/user")
    public List<User> GetUser() {

        return userService.getUser();
    }

    @RequestMapping (value = "user9")
    public User GetUser9() {
        User u9 = new User();
        u9.setName("jorgue");


        return u9;
    }

}
