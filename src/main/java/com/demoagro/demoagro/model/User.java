package com.demoagro.demoagro.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter @Setter @Column(name = "email")
    private String email;
    @Getter @Setter @Column(name = "password")
    private String password;
    @Getter @Setter @Column(name = "name")
    private String name;
    @Getter @Setter @Column(name = "lastname")
    private String lastname;
}
