package org.atousa.items.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Atousa Mirhosseini
 * @since 03 Aug, 2024
 */
@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private ErrorType errorType;
    private String message;
}
