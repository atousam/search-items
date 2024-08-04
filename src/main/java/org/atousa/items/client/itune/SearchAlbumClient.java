package org.atousa.items.client.itune;

import org.atousa.items.client.itune.dto.AlbumItuneResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Atousa Mirhosseini
 * @since 02 Aug, 2024
 */
@FeignClient(name = "itune", url = "${contract.external.album.itune.url}", configuration = ItuneFeignConfig.class)
public interface SearchAlbumClient {

    @GetMapping(value = "", consumes = "application/json")
    AlbumItuneResponseDto getResult(@RequestParam String entity, @RequestParam String term, @RequestParam Long limit);
}
