package com.demoagro.demoagro.service;

import com.demoagro.demoagro.model.User;

import java.util.List;

public interface UserService {


   List<User> getUser();




   void eliminar(Long id);

   void register(User user);
}
