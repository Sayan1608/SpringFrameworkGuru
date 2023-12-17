package com.junit.rest.controllers;

import com.junit.rest.model.Book;
import com.junit.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;




import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getBookList(){
        return bookRepository.findAll();
    }
    @GetMapping("{bookId}")
    public Book getBookById(@PathVariable("bookId") Long bookId){
        return bookRepository.findById(bookId).get();
    }

    @PostMapping
    public Book saveBook(@RequestBody @Validated Book bookRecord){
        return bookRepository.save(bookRecord);
    }

    @PutMapping
    public Book updateBook(@RequestBody  @Validated Book bookRecord) throws Exception {
        if(bookRecord == null || bookRecord.getBookId() == null){
            throw new Exception("Book-record or ID must not be null");
        }
        Optional<Book> optionalBook = bookRepository.findById(bookRecord.getBookId());
        if(optionalBook.isEmpty()){
            throw new Exception("Book with ID " + bookRecord.getBookId() + " not Found.");
        }
        Book existingBook = optionalBook.get();

        existingBook.setName(bookRecord.getName());
        existingBook.setSummary(bookRecord.getSummary());
        existingBook.setRating(bookRecord.getRating());
        return bookRepository.save(existingBook);
    }

    @DeleteMapping("{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) throws Exception {
        if(bookRepository.findById(bookId).isEmpty()){
            throw new Exception("Book with ID : " + bookId + " does not exist");
        }
        bookRepository.deleteById(bookId);
    }


}
