package com.demoagro.demoagro.controller;

import com.demoagro.demoagro.model.User;
import com.demoagro.demoagro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        if (userService.verificarCredenciales(user)) {
            return "OK";
        } else {
            return "ERROR";
        }

    }
}
