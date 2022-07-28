package com.example.bookstoreproject.mapper;

import com.example.bookstoreproject.BookRequest;
import com.example.bookstoreproject.model.domain.Book;
import com.example.bookstoreproject.response.BookResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponse bookToBookResponse(Book book);
    Book bookRequestToBook (BookRequest bookRequest);
}
