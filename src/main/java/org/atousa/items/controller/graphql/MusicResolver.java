package org.atousa.items.controller.graphql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atousa.items.dto.book.BookItemResponseDto;
import org.atousa.items.dto.music.MusicItemResponseDto;
import org.atousa.items.service.MusicService;
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
public class MusicResolver {
    private final MusicService musicService;

    @SchemaMapping(typeName = "SearchResponseDto", field = "musics")
    public List<MusicItemResponseDto> fetchMusics(@ContextValue(name = "term") String term) {
        log.debug("Inside fetching musics of schema: {}", term);
        return musicService.getMusics(term);
    }
}
