package com.kokoo.springboot3.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @Operation(
            tags = "get-tag",
            summary = "get summary",
            description = "get description"
    )
    @GetMapping("")
    public String getSwaggerSample(@Parameter(name = "dummy", example = "-") @RequestParam String dummy) {
        return dummy;
    }

    @Operation(
            tags = "post-tag",
            summary = "post summary",
            description = "post description"
    )
    @PostMapping("")
    public SwaggerDto postSwaggerSample(@RequestBody SwaggerDto swaggerDto) {
        return swaggerDto;
    }
}
