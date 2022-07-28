package com.example.bookstoreproject.resource;

import com.example.bookstoreproject.BookRequest;
import com.example.bookstoreproject.mapper.BookMapper;
import com.example.bookstoreproject.model.domain.Book;
import com.example.bookstoreproject.model.service.BookService;
import com.example.bookstoreproject.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(("/v1/books"))
public class BookResource {
    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookService.findAll(pageable)
                .map(bookMapper::bookToBookResponse);
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable String id) {
        Book bookById = bookService.findById(id);
        return bookMapper.bookToBookResponse(bookById);
    }

    @PostMapping
    public BookResponse save(@RequestBody BookRequest bookRequest) {
        Book book = bookMapper.bookRequestToBook(bookRequest);
        bookService.save(book);
        BookResponse bookResponse = bookMapper.bookToBookResponse(book);
        return bookResponse;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        bookService.delete(id);
    }

}
