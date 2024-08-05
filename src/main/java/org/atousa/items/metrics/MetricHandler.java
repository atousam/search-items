package org.atousa.items.metrics;

import io.micrometer.core.instrument.ImmutableTag;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

/**
 * @author Atousa Mirhosseini
 * @since 05 Aug, 2024
 */
@RequiredArgsConstructor
@Component
public class MetricHandler {
    public static final String REGISTRY_NAME = "search_items_upstream";
    public static final String SERVICE_NAME = "service_name";
    private final PrometheusMeterRegistry registry;

    public void registerTime(String serviceName, long responseTime) {
        registry.timer(REGISTRY_NAME, List.of(new ImmutableTag(SERVICE_NAME, serviceName)))
                .record(Duration.ofMillis(responseTime));
    }
}
