package org.atousa.items.message;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author Atousa Mirhosseini
 * @since 03 Aug, 2024
 */
@RequiredArgsConstructor
@Component
public class LocaleMessageResource {
    private final MessageSource messageSource;

    public String getMessage(String code) {
        Locale locale = new Locale("fa");
        return messageSource.getMessage(code, null, locale);
    }

    public String getMessage(String code, Object... objects) {
        Locale locale = new Locale("fa");
        return messageSource.getMessage(code, objects, locale);
    }
}
