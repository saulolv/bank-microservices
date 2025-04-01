package com.study.accounts.Application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
@Data @AllArgsConstructor
public class ErrorResponseDto {

    @Schema(
            description = "API path where the error occurred",
            example = "/api/accounts"
    )
    private String apiPath;

    @Schema(
            description = "HTTP status code of the error"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message describing the error"
    )
    private String errorMessage;

    @Schema(
            description = "Timestamp when the error occurred",
            example = "2023-10-01T12:00:00"
    )
    private LocalDateTime errorTimestamp;
}
