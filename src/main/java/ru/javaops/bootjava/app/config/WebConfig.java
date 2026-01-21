package ru.javaops.bootjava.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public static final String VERSION_HEADER = "API-Version";
    public static final String CURRENT_VERSION = "1.0";

    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer
                .useRequestHeader(VERSION_HEADER)
                .setVersionRequired(false)
                .setDefaultVersion(CURRENT_VERSION)
                .addSupportedVersions(CURRENT_VERSION);
    }
}