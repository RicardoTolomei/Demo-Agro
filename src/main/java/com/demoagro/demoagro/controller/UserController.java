package com.demoagro.demoagro.controller;

import com.demoagro.demoagro.model.User;
import com.demoagro.demoagro.service.UserService;
import com.demoagro.demoagro.util.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SpringBootApplication

public class UserController {

    @Autowired
    private  UserService userService;
    @Autowired
    private JWTUtil jwtUtil;



        @RequestMapping(value = "api/user", method = RequestMethod.GET)

        public List<User> GetUser(@RequestHeader(value="Authorization") String token) {

            if (!validarToken(token)) { return null; }

            return userService.getUser();

        }

    private boolean validarToken(String token) {
        String userId = jwtUtil.getKey(token);
        return userId != null;

}
    @RequestMapping(value = "api/user", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
           String hash =  argon2.hash(1,1024,1,user.getPassword());
           user.setPassword(hash);

        userService.register(user);
    }


    @CrossOrigin(origins ="file:///C:/Users/tolom/Documents/Proyectos%20Porgramacion/demoagro/src/main/resources/static/users.html" )
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestHeader(value="Authorization") String token,
                       @PathVariable Long id) {

        if (!validarToken(token)) { return; }
        userService.eliminar(id);
    }

}








