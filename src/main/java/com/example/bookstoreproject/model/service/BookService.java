package com.example.bookstoreproject.model.service;

import com.example.bookstoreproject.model.domain.Book;
import com.example.bookstoreproject.model.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public Page<Book> findAll(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public Book findById(String id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public void delete(String id){
        bookRepository.deleteById(id);
    }

}
