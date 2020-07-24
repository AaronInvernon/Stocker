package com.ironhack.Client.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GlobalHandlerTest {

    private GlobalHandler globalHandler = new GlobalHandler();
    private MockHttpServletResponse response;

    @BeforeEach
    void setUp() { response = new MockHttpServletResponse(); }


    @Test
    void handleClientNotFoundException() throws IOException {
        globalHandler.handleClientNotFoundException(new ClientNotFoundException("ClientNotFound"), response);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }
}