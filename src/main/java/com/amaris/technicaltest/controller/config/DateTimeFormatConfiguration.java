package com.amaris.technicaltest.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
public class DateTimeFormatConfiguration {

    @Bean
    public Formatter<LocalDateTime> localDateFormatter() {
        return new Formatter<>() {
            @Override
            public LocalDateTime parse(String text, Locale locale) {
                return LocalDateTime.parse(text, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            }

            @Override
            public String print(LocalDateTime object, Locale locale) {
                return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(object);
            }
        };
    }

}