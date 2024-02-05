package com.example.libraryproject.books.service;

import com.example.libraryproject.books.DTO.BookDTO;
import com.example.libraryproject.books.repository.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks(int sortedId) {
        if (sortedId == 1) {
            return bookRepository.findAllSortedByPagesAsc();
        }
        if (sortedId == 2) {
            return bookRepository.findAllSortedByPagesDesc();
        }
        return bookRepository.findAll();
    }


    public List<BookDTO> getBookByISBN(String isbn) {
        return bookRepository.findByISBN(isbn)
                .map(Collections::singletonList)
                .orElseGet(Collections::emptyList);
    }

    public List<BookDTO> getBookByTitle(String title) {
        return bookRepository.findByTitle(title)
                .map(Collections::singletonList)
                .orElseGet(Collections::emptyList);
    }

    public List<BookDTO> getBooksByAuthorAsc(String author) {
        return bookRepository.findByAuthorAsc(author);
    }
    public List<BookDTO> getBooksByAuthorDesc(String author) {
        return bookRepository.findByAuthorDesc(author);
    }
    public List<BookDTO> getBooksById(String author){
        return bookRepository.sortById(author);
    }
    public List<BookDTO> getBookById(Long id) {
        Optional<BookDTO> book = bookRepository.findById(id);
        return book.map(Collections::singletonList)
                .orElseGet(Collections::emptyList);
    }

    public void addBook(@NotNull BookDTO bookDTO) {
        BookDTO newBook = new BookDTO(bookDTO.getISBN(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getPublicationYear(), bookDTO.getPages());
        bookRepository.save(newBook);
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public BookDTO updateBook(BookDTO bookDTO){
        return bookRepository.save(bookDTO);
    }


}
