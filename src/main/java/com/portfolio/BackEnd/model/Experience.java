package com.portfolio.BackEnd.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String position;
    private Long timeStart;
    private Long timeEnd;
    private String location;
    private String url;

    public Experience() {
    }

}
