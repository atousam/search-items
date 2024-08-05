package org.atousa.items.client;

import feign.Logger;
import org.atousa.items.metrics.MetricHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Atousa Mirhosseini
 * @since 05 Aug, 2024
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public CustomizeLogFeign feignLogging(MetricHandler metricHandler) {
        return new CustomizeLogFeign(metricHandler);
    }
}
