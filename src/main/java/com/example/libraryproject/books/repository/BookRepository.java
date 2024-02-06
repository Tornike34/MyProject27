package com.example.libraryproject.books.repository;

import com.example.libraryproject.books.DTO.BookDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookDTO,Long>{

    @Query("SELECT b from BookDTO b WHERE b.title = :title ORDER BY b.id ASC")
    List<BookDTO> findByTitleASC(String title);
    @Query("SELECT b from BookDTO b WHERE b.title = :title ORDER BY b.id DESC")
    List<BookDTO> findByTitleDESC(String title);
    @Query("SELECT b FROM BookDTO b WHERE b.ISBN = :isbn ORDER BY b.id ASC ")
    List<BookDTO> findByISBNASC(String isbn);
    @Query("SELECT b FROM BookDTO b WHERE b.ISBN = :isbn ORDER BY b.id DESC")
    List<BookDTO> findByISBNDESC(String isbn);
    @Query("SELECT b FROM BookDTO b WHERE b.author = :author ORDER BY b.pages ASC")
    List<BookDTO> findByAuthorAsc(@Param("author") String author);

    @Query("SELECT b FROM BookDTO b WHERE b.author = :author ORDER BY b.id desc ")
    List<BookDTO> sortById(@Param("author") String author);

    @Query("SELECT b FROM BookDTO b WHERE b.author = :author ORDER BY b.pages desc ")
    List<BookDTO> findByAuthorDesc(@Param("author") String author);
    @Query("SELECT b from  BookDTO b order by b.pages asc")
    List<BookDTO> findAllSortedByPagesAsc();
    @Query("SELECT b from  BookDTO b order by b.pages desc ")
    List<BookDTO> findAllSortedByPagesDesc();

    Optional<BookDTO> findById(@NotNull Long id);
}
