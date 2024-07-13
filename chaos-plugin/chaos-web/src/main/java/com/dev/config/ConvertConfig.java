package com.dev.config;

import com.dev.core.util.date.DateStyle;
import com.dev.core.util.date.DateUtil;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * ConvertConfig
 *
 * @author dengrijin
 * @version v0.1 2020/07/23
 */
@ConditionalOnProperty(name = "spring.jackson.serialization.write-dates-as-timestamps")
@Configuration
public class ConvertConfig {
    private static final Logger log = LoggerFactory.getLogger(ConvertConfig.class);

    public ConvertConfig() {
        log.info("init string to Date Convert!");
    }

    @Bean
    public Converter<String, Date> stringToDateConvert(JacksonProperties jacksonProperties) {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                Date date;
                try {
                    boolean asTimestamps = jacksonProperties.getSerialization().getOrDefault(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
                    if (asTimestamps) {
                        return new Date(Long.parseLong(source));
                    }
                    String dateFormat = jacksonProperties.getDateFormat();
                    if (Strings.isBlank(dateFormat)) {
                        dateFormat = DateStyle.YYYY_MM_DD_HH_MM.getValue();
                    }
                    date = DateUtil.stringToDate(source, dateFormat);
                } catch (Exception e) {
                    throw new RuntimeException("String to Date Convert Error");
                }
                return date;
            }
        };
    }
}
