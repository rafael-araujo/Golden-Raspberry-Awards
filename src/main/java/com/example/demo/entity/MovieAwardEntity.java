package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="TB_MOVIES_LIST")
public class MovieAwardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`year`")
    private Integer year;
    private String title;
    private String studios;
    private String producers;
    private Boolean winner;

}
