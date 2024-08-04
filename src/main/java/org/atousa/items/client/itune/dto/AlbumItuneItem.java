package org.atousa.items.client.itune.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@Setter
@Getter
public class AlbumItuneItem {
    private String wrapperType;
    private String collectionType;
    private Long artistId;
    private Long collectionId;
    private Long amgArtistId;
    private String artistName;
    private String collectionName;
    private String collectionCensoredName;
    private String artistViewUrl;
    private String collectionViewUrl;
    private String artworkUrl60;
    private String artworkUrl100;
    private Float collectionPrice;
    private String collectionExplicitness;
    private Integer trackCount;
    private String copyright;
    private String country;
    private String currency;
    private String releaseDate;
    private String primaryGenreName;
}
