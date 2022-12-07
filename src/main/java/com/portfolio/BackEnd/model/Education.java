package com.portfolio.BackEnd.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private Long timeStart;
    private Long timeEnd;
    private String location;
    private String img;
    private String url;


    public Education() {
    }


}
