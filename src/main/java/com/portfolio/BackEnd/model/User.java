package com.portfolio.BackEnd.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String profileBg;
    private String profilePic;
    private String currentPosition;
    private String location;
    private String about;

    public User() {

    }
}
