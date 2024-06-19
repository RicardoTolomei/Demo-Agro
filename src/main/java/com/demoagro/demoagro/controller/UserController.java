package com.demoagro.demoagro.controller;

import com.demoagro.demoagro.model.User;
import com.demoagro.demoagro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SpringBootApplication

public class UserController {

    @Autowired
    private  UserService userService;



        @RequestMapping(value = "api/user", method = RequestMethod.GET)

        public List<User> GetUser() {

        return userService.getUser();
}
    @RequestMapping(value = "api/user", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {

        userService.register(user);
    }


    @CrossOrigin(origins ="file:///C:/Users/tolom/Documents/Proyectos%20Porgramacion/demoagro/src/main/resources/static/users.html" )
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {


        userService.eliminar(id);
    }

}






