package com.manningbooks.catalogservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "polar")
@Getter
@Setter
public class PolarProperties {

    /**
     * A message to welcome users.
     */
    private String greeting;

}
