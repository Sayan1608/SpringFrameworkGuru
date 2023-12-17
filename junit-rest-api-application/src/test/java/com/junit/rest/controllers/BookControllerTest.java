package com.junit.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junit.rest.model.Book;
import com.junit.rest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @MockBean
    BookRepository bookRepository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Book RECORD_1 = Book.builder()
            .bookId(1L)
            .name("Atomic Habits")
            .summary("How to create better habits")
            .rating(5)
            .build();

    private Book RECORD_2 = Book.builder()
            .bookId(2L)
            .name("The Power of Your Subconscious Mind")
            .summary("How to use your inner power")
            .rating(5)
            .build();

    @Test
    void getBookList() throws Exception {
        List<Book> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));

        given(bookRepository.findAll()).willReturn(records);

        mockMvc.perform(get("/book")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(2)))
                .andExpect(jsonPath("$[0].name", is("Atomic Habits")));
    }


    @Test
    void getBookById() throws Exception {
        Book testBook = RECORD_1;

        given(bookRepository.findById(any(Long.class))).willReturn(Optional.ofNullable(testBook));

        mockMvc.perform(get("/book/" + testBook.getBookId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.bookId", is(testBook.getBookId())))
                .andExpect(jsonPath("$.name", is(testBook.getName())));
    }


    @Test
    void saveBook() throws Exception {
        Book savedBook = RECORD_2;

        given(bookRepository.save(any(Book.class))).willReturn(savedBook);

        mockMvc.perform(post("/book")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(savedBook)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(savedBook.getName())));
    }

    @Test
    void updateBook() throws Exception {
        Book newBook = Book.builder()
                .bookId(RECORD_1.getBookId())
                .name("You can Heal Yourself")
                .summary("Self Help")
                .rating(4)
                .build();

        given(bookRepository.findById(any(Long.class))).willReturn(Optional.ofNullable(RECORD_1));
        given(bookRepository.save(any(Book.class))).willReturn(newBook);

        mockMvc.perform(put("/book")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newBook)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(newBook.getName())));

    }

    @Test
    void deleteBook() throws Exception {

        given(bookRepository.findById(any(Long.class))).willReturn(Optional.ofNullable(RECORD_1));

        mockMvc.perform(delete("/book/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}