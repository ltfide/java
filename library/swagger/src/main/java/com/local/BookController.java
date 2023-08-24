package com.local;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class BookController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return books;
    }

    @Parameters({
            @Parameter(in = ParameterIn.HEADER, name = "sysinfo.ret_ref_no", required = true, schema = @Schema(type = "string", defaultValue = "000000000001"))
    })
    @Operation(summary = "[SaveBook]", description = "Call SaveBook Service")
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }
}
