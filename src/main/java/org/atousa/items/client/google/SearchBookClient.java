package org.atousa.items.client.google;

import org.atousa.items.client.google.dto.BookGoogleResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */

@FeignClient(name = "google", url = "${contract.external.book.google.url}")
public interface SearchBookClient {
    @GetMapping(path = "/books/v1/volumes")
    BookGoogleResponseDto getBookSearch(@RequestParam String q, @RequestParam Long maxResults, @RequestParam String key);
}
