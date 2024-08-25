package org.atousa.items.controller.graphql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atousa.items.dto.book.BookItemResponseDto;
import org.atousa.items.service.BookService;
import org.springframework.graphql.data.method.annotation.ContextValue;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Atousa Mirhosseini
 * @since 25 Aug, 2024
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class BookResolver {
    private final BookService bookService;

    @SchemaMapping(typeName = "SearchResponseDto", field = "books")
    public List<BookItemResponseDto> fetchBooks(@ContextValue(name = "term") String term) {
        log.debug("Inside fetching book of schema: {}", term);
        return bookService.getBooks(term);
    }
}
