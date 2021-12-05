package com.sejawal.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    final  private String resourceName;
    final private String fieldName;
    final  private String fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
//        super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
        this(resourceName, fieldName, String.valueOf(fieldValue));

    }
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }
}