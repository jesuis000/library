package com.edfapay.library.services;


import com.edfapay.library.exceptions.BookNotFoundException;
import com.edfapay.library.models.BookModel;
import com.edfapay.library.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<BookModel> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public BookModel getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    public BookModel createBook(BookModel book) {
        return bookRepository.save(book);
    }

    public BookModel updateBook(Long id, BookModel bookDetails) {
        BookModel book = getBookById(id);
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublishedDate(bookDetails.getPublishedDate());
        book.setIsbn(bookDetails.getIsbn());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        BookModel book = getBookById(id);
        bookRepository.delete(book);
    }

    public Page<BookModel> searchBooks(String query, Pageable pageable) {
        Specification<BookModel> spec = (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.or(
                        criteriaBuilder.like(root.get("title"), "%" + query + "%"),
                        criteriaBuilder.like(root.get("author"), "%" + query + "%")
                );
        return bookRepository.findAll(spec, pageable);
    }
}
