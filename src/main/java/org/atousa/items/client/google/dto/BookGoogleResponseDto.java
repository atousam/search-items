package org.atousa.items.client.google.dto;

import lombok.Getter;

import java.util.List;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@Getter
public class BookGoogleResponseDto {
    private String kind;
    private Long totalItems;
    private List<BookGoogleItem> items;
}
