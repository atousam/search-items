package org.atousa.items.client.google.dto;

import lombok.Getter;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@Getter
public class BookGoogleItem {
    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private BookGoogleVolumeInfo volumeInfo;
    private BookGoogleSaleInfo saleInfo;
    private BookGoogleAccessInfo accessInfo;
    private BookGoogleSearchInfo searchInfo;
}
