package com.empty.searcher.common.base.exception.handler;

import com.empty.searcher.common.base.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static com.empty.searcher.common.base.constants.SearcherConstants.INTERNAL_SERVER_ERROR_MESSAGE;
import static com.empty.searcher.common.base.constants.SearcherConstants.NOT_VALID_ARGUMENTS;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(x -> x.getDefaultMessage())
            .collect(Collectors.toList());

        return new ResponseEntity<>(ErrorResponse.from(NOT_VALID_ARGUMENTS, errors), BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    public final ResponseEntity<Object> handleInternalServerError(RuntimeException ex, WebRequest request) {
        log.info("INTERNAL_SERVER_ERROR_MESSAGE", ex);
        return new ResponseEntity<>(ErrorResponse.from(INTERNAL_SERVER_ERROR_MESSAGE, ex.getMessage()), INTERNAL_SERVER_ERROR);
    }
}
