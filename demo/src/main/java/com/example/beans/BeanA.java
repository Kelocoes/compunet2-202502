package com.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanA {

    @Value("#{'prod'.equals('${app.environment}')}")
    private Boolean message;

    public Boolean getMessage() {
        return message;
    }

    public void setMessage(Boolean message) {
        this.message = message;
    }

}
