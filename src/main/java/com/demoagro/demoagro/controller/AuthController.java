package com.demoagro.demoagro.controller;


import com.demoagro.demoagro.model.User;
import com.demoagro.demoagro.service.UserService;
import com.demoagro.demoagro.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;
@RequestMapping(value = "api/login" , method = RequestMethod.POST)
    public String login(@RequestBody User user){
User userlogin = userService.obtenerUserPorCredenciales(user);
    if(userlogin != null){
       String tokenJwt = jwtUtil.create(String.valueOf(userlogin.getId()), userlogin.getEmail());
        return tokenJwt;
    }
    return "FAIL";

    }
}
