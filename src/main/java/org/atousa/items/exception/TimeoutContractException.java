package org.atousa.items.exception;

/**
 * @author Atousa Mirhosseini
 * @since 03 Aug, 2024
 */
public class TimeoutContractException extends BusinessException {
    public TimeoutContractException(ErrorType errorType, String message) {
        super(errorType, message);
    }
}
