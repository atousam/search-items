package org.atousa.items.controller;

import lombok.RequiredArgsConstructor;
import org.atousa.items.dto.SearchResponseDto;
import org.atousa.items.service.SearchService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@RequestMapping("/api/search")
@RequiredArgsConstructor
@RestController
public class SearchController {

    private final SearchService service;

    @GetMapping("")
    public SearchResponseDto searchItems(@RequestParam String term) {
        return service.searchItems(term);
    }
}
