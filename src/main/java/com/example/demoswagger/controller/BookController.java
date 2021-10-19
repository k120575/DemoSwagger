package com.example.demoswagger.controller;

import com.example.demoswagger.dto.BookDto;
import com.example.demoswagger.entity.Book;
import com.example.demoswagger.repository.BookRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Book")
@RestController
@RequestMapping(value = "/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @ApiOperation(value = "取得書本", notes = "列出所有書本")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @ApiOperation(value = "新增書本", notes = "新增書本的內容")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "存檔成功")})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/v1/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto create(
            @ApiParam(required = true, value = "書本內容") @RequestBody BookDto bookDto) {
        Book book = new Book();
        book.setBookId(bookDto.getBookId());
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book = bookRepository.save(book);
        bookDto.setBookId(book.getBookId());
        return bookDto;
    }

    @ApiOperation(value = "取得書本內容", notes = "取得書本內容")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "書本資訊")})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/book/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto get(
            @ApiParam(required = true, name = "bookId", value = "書本ID") @PathVariable Integer bookId) {
        Book book = bookRepository.findByBookId(bookId);
        BookDto bookDto = new BookDto();
        bookDto.setBookId(book.getBookId());
        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        return bookDto;
    }
}
