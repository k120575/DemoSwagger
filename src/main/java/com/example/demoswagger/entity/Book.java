package com.example.demoswagger.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "bookid")
    private Integer bookId;

    private String name;

    private String author;
}
