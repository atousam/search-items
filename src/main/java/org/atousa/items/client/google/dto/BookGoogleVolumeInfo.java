package org.atousa.items.client.google.dto;

import lombok.Getter;

import java.util.List;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@Getter
public class BookGoogleVolumeInfo {
    private String title;
    private String subtitle;
    private List<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private List<BookGoogleIndustryIdentifier> industryIdentifiers;
    private BookGoogleVolumeMode readingModes;
    private Long pageCount;
    private String printType;
    private List<String> categories;
    private Float averageRating;
    private Long ratingsCount;
    private String maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    private BookGooglePanelizationSummary panelizationSummary;
    private BookGoogleImageLinks imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;

}
