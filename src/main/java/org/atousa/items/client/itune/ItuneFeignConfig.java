package org.atousa.items.client.itune;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Util;
import feign.codec.Decoder;
import org.atousa.items.client.itune.dto.AlbumItuneResponseDto;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * @author Atousa Mirhosseini
 * @since 04 Aug, 2024
 */
public class ItuneFeignConfig {
    @Bean
    public Decoder feignDecoder() {
        return (response, type) -> {
            String body = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            if (response.headers().getOrDefault("Content-Type", Collections.emptyList()).contains("text/javascript; charset=utf-8")) {
                // Handle text/javascript response
                return new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                        .readValue(body, AlbumItuneResponseDto.class);
            } else {
                throw new FeignException.FeignClientException(
                        response.status(),
                        "Unexpected content type",
                        response.request(),
                        body.getBytes(StandardCharsets.UTF_8),
                        response.headers()
                );
            }
        };
    }
}
