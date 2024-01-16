package com.kokoo.springboot3.cloud;

import io.micrometer.tracing.TraceContext;
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

    @GetMapping("/sleuth")
    public void getSleuth(HttpServletRequest request) {
        TraceContext traceContext = tracer.currentTraceContext().context();
        if (traceContext != null) {
            log.info("trace id :: {}", traceContext.traceId());
            log.info("span id :: {}", traceContext.spanId());
        }
    }
}
