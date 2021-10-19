package com.example.demoswagger.repository;

import com.example.demoswagger.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByBookId(Integer bookId);

    Page<Book> findAll(Pageable pageable);

    Book save(Book s);
}
