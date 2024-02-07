package com.kokoo.springboot3.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class SwaggerDto {

    @Schema(example = "-")
    private String dummy;
}
