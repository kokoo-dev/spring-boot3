package com.kokoo.springboot3.cloud;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/cloud")
@RequiredArgsConstructor
public class CloudController {

    private final Tracer tracer;
    private final CloudClient cloudClient;

    @GetMapping("/sleuth")
    public void getSleuth(HttpServletRequest request) {
        Span span = tracer.currentSpan();
        if (span != null) {
            log.info("trace id :: {}", span.context().traceId());
            log.info("span id :: {}", span.context().spanId());
        }

        cloudClient.testSleuth();
    }
}
