package com.example.libraryproject.books.controller;

import com.example.libraryproject.books.DTO.BookDTO;
import com.example.libraryproject.books.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/sortedId/{sortedId}")
    public List<BookDTO> getAllBook(@PathVariable int sortedId){
        return bookService.getAllBooks(sortedId);
    }



    @GetMapping("/search/byISBN/{isbn}/sortedId/{sortedId}")
    public List<BookDTO> searchBooksByISBN(@PathVariable String isbn,@PathVariable Integer sortedId) {
        return bookService.getBookByISBN(isbn,sortedId);
    }

    @GetMapping("/search/byTitle/{title}/sortedId/{sortedId}")
    public List<BookDTO> searchBooksByTitle(@PathVariable String title,@PathVariable Integer sortedId){
        return bookService.getBookByTitle(title,sortedId);
    }

    @GetMapping("/search/byAuthor/{author}/sortedId/{sortedId}")
    public List<BookDTO> searchBooksByAuthor(@PathVariable String author,@PathVariable Integer sortedId){
        return bookService.getBooksByAuthor(author,sortedId);

    }
    @GetMapping("/search/byId/{id}")
    public Optional<BookDTO> searchBooksById(@PathVariable Long id){
        return bookService.getBookById(id);
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



