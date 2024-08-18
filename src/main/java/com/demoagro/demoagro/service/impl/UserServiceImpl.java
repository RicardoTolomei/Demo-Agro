package com.demoagro.demoagro.service.impl;

import com.demoagro.demoagro.model.User;
import com.demoagro.demoagro.service.UserService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public void eliminar(Long id) {
        User u2 = entityManager.find(User.class, id);
        entityManager.remove(u2);

    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }

    @Override
    public boolean verificarCredenciales(User user) {

        String query = "FROM User WHERE email = :email ";
                List<User> lista = entityManager.createQuery(query)


                        .setParameter(  "email", user.getEmail())
                        .getResultList();
                if (lista.isEmpty()) {return false;}
                String passwordHashed = lista.get(0).getPassword();

                        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
                             return  argon2.verify(passwordHashed,user.getPassword());







    }


}
