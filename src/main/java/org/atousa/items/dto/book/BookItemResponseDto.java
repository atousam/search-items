package org.atousa.items.dto.book;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@Getter
@Builder
public class BookItemResponseDto implements Serializable {
    private String title;
    private String subtitle;
    private List<String> authors;
    private String publishedDate;
    private String publisher;
    private String description;
    private Long pageCount;
    private List<String> categories;
}
