package com.empty.searcher.common.base.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private String code;
    private Object data;

    public static ErrorResponse from(String message, Object data) {
        return ErrorResponse.builder()
            .message(message)
            .data(data)
            .build();
    }
}
