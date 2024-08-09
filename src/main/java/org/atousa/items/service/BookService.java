package org.atousa.items.service;

import feign.RetryableException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atousa.items.cache.CacheNames;
import org.atousa.items.client.google.SearchBookClient;
import org.atousa.items.dto.book.BookItemResponseDto;
import org.atousa.items.exception.BusinessException;
import org.atousa.items.exception.ErrorType;
import org.atousa.items.exception.TimeoutContractException;
import org.atousa.items.message.LocaleMessageResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Atousa Mirhosseini
 * @since 03 Aug, 2024
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {
    @Value("${contract.external.book.google.max}")
    private Long maxResult;

    @Value("${contract.external.book.google.key}")
    private String keyApi;

    private final SearchBookClient bookClient;
    private final LocaleMessageResource messageResource;

    @Cacheable(value = CacheNames.BOOKS, key = "#term")
    @CircuitBreaker(name = CircuitBreakerName.BOOK)
    public List<BookItemResponseDto> getBooks(String term) {
        try {
            return bookClient.getBookSearch(term, maxResult, keyApi)
                    .getItems()
                    .stream().map(bg -> BookItemResponseDto.builder()
                            .title(bg.getVolumeInfo().getTitle())
                            .subtitle(bg.getVolumeInfo().getSubtitle())
                            .authors(bg.getVolumeInfo().getAuthors())
                            .publishedDate(bg.getVolumeInfo().getPublishedDate())
                            .publisher(bg.getVolumeInfo().getPublisher())
                            .description(bg.getVolumeInfo().getDescription())
                            .pageCount(bg.getVolumeInfo().getPageCount())
                            .categories(bg.getVolumeInfo().getCategories())
                            .build())
                    .sorted(Comparator.comparing(BookItemResponseDto::getTitle))
                    .toList();
        } catch (RetryableException retryableException) {
            log.error("Exception in calling Google books, ", retryableException);
            if (retryableException.getCause() instanceof SocketTimeoutException) {
                throw new TimeoutContractException(ErrorType.TIMEOUT_EXCEPTION, messageResource.getMessage("book.timeout.provider"));
            } else {
                throw new BusinessException(ErrorType.GENERAL_EXCEPTION, messageResource.getMessage("book.general.error"));
            }
        }
    }
}
