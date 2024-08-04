package org.atousa.items.dto.error;

import lombok.Getter;
import lombok.Setter;
import org.atousa.items.exception.ErrorType;

/**
 * @author Atousa Mirhosseini
 * @since 03 Aug, 2024
 */
@Setter
@Getter
public class ErrorResponseDto {
    private ErrorType error;
    private String message;
}
