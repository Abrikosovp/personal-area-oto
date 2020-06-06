package com.example.personalareaoto.model;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "_usr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "_email")
    private String email;

    @Column(name = "_user_name")
    private String username;

    @Column(name = "_password")
    private String password;

    @Column(name = "_return_secure_token")
    private Boolean returnSecureToken;

}
