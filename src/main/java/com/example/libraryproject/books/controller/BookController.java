package com.example.libraryproject.books.controller;

import com.example.libraryproject.books.DTO.BookDTO;
import com.example.libraryproject.books.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/sortedId")
    public ResponseEntity<List<BookDTO>> getAllBook(
            @RequestParam(required = false) int sortedId) {
        List<BookDTO> books = null;
        if (sortedId == 1) {
            books = bookService.getAllBooks(sortedId);
        }
        if (sortedId == 2) {
            books = bookService.getAllBooks(sortedId);
        }

        return ResponseEntity.ok(books);
    }


    @GetMapping("/search/byISBN")
    public ResponseEntity<List<BookDTO>> searchBooksByISBN(
            @RequestParam(required = false) String isbn) {
        List<BookDTO> books = null;
        if (isbn != null) {
            books = bookService.getBookByISBN(isbn);
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/byTitle")
    public ResponseEntity<List<BookDTO>> searchBooksByTitle(
            @RequestParam(required = false) String title) {
        List<BookDTO> books = null;
        if (title != null) {
            books = bookService.getBookByTitle(title);
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/byAuthor")
    public ResponseEntity<List<BookDTO>> searchBooksByAuthor(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) int sortedId) {
        List<BookDTO> books;
        switch (sortedId) {
            case 1:
                books = bookService.getBooksByAuthorAsc(author);
                break;
            case 2:
                books = bookService.getBooksByAuthorDesc(author);
                break;
            case 0:
                books = bookService.getBooksById(author);
                break;
            default:
                return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/ById")
    public ResponseEntity<List<BookDTO>> searchBooksById(
            @RequestParam(required = false) Long id) {
        List<BookDTO> books = null;
        if (id != 0) {
            books = bookService.getBookById(id);
        }
        return ResponseEntity.ok(books);
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        return new ResponseEntity<>("Book was added successfully!", HttpStatus.OK);
    }
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBoook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted successfully",HttpStatus.OK);
    }
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody @NotNull BookDTO updatedBookDTO){
        updatedBookDTO.setId(id);
        BookDTO updatedBookDTOData = bookService.updateBook(updatedBookDTO);
        return ResponseEntity.ok(updatedBookDTOData);
    }
}



