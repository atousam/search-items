package org.atousa.items.dto;

import lombok.Builder;
import lombok.Getter;
import org.atousa.items.dto.book.BookItemResponseDto;
import org.atousa.items.dto.music.MusicItemResponseDto;

import java.util.List;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@Getter
@Builder
public class SearchResponseDto {
    private List<BookItemResponseDto> books;
    private List<MusicItemResponseDto> musics;
}
