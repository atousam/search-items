package org.atousa.items.client;

import feign.Logger;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atousa.items.metrics.MetricHandler;

import java.io.IOException;

/**
 * @author Atousa Mirhosseini
 * @since 05 Aug, 2024
 */
@Slf4j
@RequiredArgsConstructor
public class CustomizeLogFeign extends Logger {
    private final MetricHandler metricHandler;

    @Override
    protected void log(String configKey, String format, Object... args) {
        if (this.log.isDebugEnabled()) {
            this.log.debug(String.format(methodTag(configKey) + format, args));
        }
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        logMetrics(response, elapsedTime);
        return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
    }

    private void logMetrics(Response response, long elapsedTime) {
        try {
            metricHandler.registerTime(response.request().requestTemplate().feignTarget().name(), elapsedTime);
        } catch (Exception e) {
            log.error("Error in metrics, ", e);
        }
    }
}
