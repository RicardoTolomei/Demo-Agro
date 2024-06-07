package com.demoagro.demoagro.service.impl;

import com.demoagro.demoagro.model.User;
import com.demoagro.demoagro.service.UserService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class UserServiceImpl implements UserService {


    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional

        public List<User> getUser() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();


    }



}
