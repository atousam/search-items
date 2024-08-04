package org.atousa.items.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atousa.items.dto.error.ErrorResponseDto;
import org.atousa.items.message.LocaleMessageResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Atousa Mirhosseini
 * @since 03 Aug, 2024
 */
@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class HandleException {
    private final LocaleMessageResource messageResource;

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorResponseDto> handleServiceExceptions(BusinessException e) {
        log.warn("Process was not successful with code:{}, message:{}", e.getErrorType(), e.getMessage());
        ErrorResponseDto responseDto = new ErrorResponseDto();
        responseDto.setMessage(e.getMessage());
        responseDto.setError(e.getErrorType());
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponseDto> handleUnhandledExceptions(Exception e) {
        log.error("Unhandled exception, ", e);
        ErrorResponseDto responseDto = new ErrorResponseDto();
        responseDto.setMessage(messageResource.getMessage("general.unhandled.exception"));
        responseDto.setError(ErrorType.GENERAL_EXCEPTION);
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
