package org.atousa.items.service;

import lombok.RequiredArgsConstructor;
import org.atousa.items.dto.SearchResponseDto;
import org.springframework.stereotype.Service;
/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@RequiredArgsConstructor
@Service
public class SearchService {
    private final BookService bookService;
    private final MusicService musicService;
    public SearchResponseDto searchItems(String term) {
        return SearchResponseDto.builder()
                .books(bookService.getBooks(term))
                .musics(musicService.getMusics(term))
                .build();
    }
}
