package org.atousa.items.client.itune.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@Setter
@Getter
public class AlbumItuneResponseDto {
    private Long resultCount;
    private List<AlbumItuneItem> results;
}
