package com.techefx.microservices.techefxpropertyacessservice.beans;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PropertyAccessValue {
    private String name;
    private String description;
}
