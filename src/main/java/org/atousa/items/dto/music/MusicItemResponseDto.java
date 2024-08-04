package org.atousa.items.dto.music;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@Getter
@Builder
public class MusicItemResponseDto implements Serializable {
    private String kind;
    private String artistId;
    private String collectionId;
    private String artistName;
    private String collectionName;
    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;
    private String releaseDate;
}
