package org.atousa.items.client.google.dto;

import lombok.Getter;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@Getter
public class BookGoogleAccessInfo {
    private String country;
    private String viewability;
    private Boolean embeddable;
    private Boolean publicDomain;
    private String textToSpeechPermission;
    private BookGoogleEpub epub;
    private BookGooglePdf pdf;
    private String webReaderLink;
    private String accessViewStatus;
    private Boolean quoteSharingAllowed;
}
