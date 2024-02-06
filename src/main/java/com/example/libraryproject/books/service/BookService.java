package com.example.libraryproject.books.service;

import com.example.libraryproject.books.DTO.BookDTO;
import com.example.libraryproject.books.repository.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return  bookRepository.findAllSortedByPagesAsc();
        }
        if (sortedId == 2) {
            return bookRepository.findAllSortedByPagesDesc();
        }
        return bookRepository.findAll();
    }


    public List<BookDTO> getBookByISBN(String isbn,Integer sortedId) {
        if(sortedId==1){
            return bookRepository.findByISBNASC(isbn);
        }
        if(sortedId==2){
            return bookRepository.findByISBNDESC(isbn);
        }
        return bookRepository.findAll();
    }

    public List<BookDTO> getBookByTitle(String title,Integer sortedId) {
        if(sortedId==1){
            return bookRepository.findByTitleASC(title);
        }
        if(sortedId==2){
            return bookRepository.findByTitleDESC(title);
        }
        return bookRepository.findAll();

    }
    public List<BookDTO> getBooksByAuthor(String author, Integer sortedId) {
        if(sortedId==1){
            return bookRepository.findByAuthorAsc(author);
        }
        if(sortedId==2){
            return bookRepository.findByAuthorDesc(author);
        }
        return bookRepository.findAll();
    }

    public Optional<BookDTO> getBookById(Long id) {
        return bookRepository.findById(id);
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
