package com.techefx.microservices.techefxpropertyacessservice.beans;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@Component
@ConfigurationProperties(prefix = "property-file")
public class PropertyAccessBean {
    private String name;
    private String description;
}
