package org.atousa.items.service;

import feign.RetryableException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atousa.items.cache.CacheNames;
import org.atousa.items.client.itune.SearchAlbumClient;
import org.atousa.items.client.itune.dto.AlbumItuneResponseDto;
import org.atousa.items.dto.music.MusicItemResponseDto;
import org.atousa.items.exception.BusinessException;
import org.atousa.items.exception.ErrorType;
import org.atousa.items.exception.TimeoutContractException;
import org.atousa.items.message.LocaleMessageResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Atousa Mirhosseini
 * @since 03 Aug, 2024
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MusicService {
    private static final String ALBUM_ENTITY = "album";
    @Value("${contract.external.album.itune.max}")
    private Long maxResult;

    private final SearchAlbumClient albumClient;
    private final LocaleMessageResource messageResource;

    @Cacheable(value = CacheNames.MUSICS, key = "#term")
    @CircuitBreaker(name = CircuitBreakerName.MUSIC)
    public List<MusicItemResponseDto> getMusics(String term) {
        try {
            Object o = albumClient.getResult(ALBUM_ENTITY, term, maxResult);
            return ((AlbumItuneResponseDto) o)
                    .getResults()
                    .stream().map(m -> MusicItemResponseDto.builder()
                            .kind(m.getCollectionType())
                            .artistId(String.valueOf(m.getArtistId()))
                            .collectionId(String.valueOf(m.getCollectionId()))
                            .artistName(m.getArtistName())
                            .collectionName(m.getCollectionName())
                            .collectionCensoredName(m.getCollectionCensoredName())
                            .releaseDate(m.getReleaseDate())
                            .build())
                    .collect(Collectors.toList());
        } catch (RetryableException retryableException) {
            log.error("Exception in calling iTune musics, ", retryableException);
            if (retryableException.getCause() instanceof SocketTimeoutException) {
                throw new TimeoutContractException(ErrorType.TIMEOUT_EXCEPTION, messageResource.getMessage("itune.timeout.provider"));
            } else {
                throw new BusinessException(ErrorType.GENERAL_EXCEPTION, messageResource.getMessage("itune.general.error"));
            }
        }
    }
}
