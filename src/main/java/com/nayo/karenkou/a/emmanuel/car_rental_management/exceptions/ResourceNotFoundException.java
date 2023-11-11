package com.nayo.karenkou.a.emmanuel.car_rental_management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    // private static final Long serialVersionUID = 1L;

    // @Getter
    private String resourceName;

    // @Getter
    private String fieldName;

    // @Getter
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {

        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));

        this.resourceName = resourceName;

        this.fieldName = fieldName;

        this.fieldValue = fieldValue;

    }

}
