package com.example.demoswagger.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 設定主鍵自增
    @Column(name = "bookid")
    private Integer bookId;

    private String name;

    private String author;
}
