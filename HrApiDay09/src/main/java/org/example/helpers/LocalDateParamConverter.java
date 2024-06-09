package org.example.helpers;

import jakarta.ws.rs.ext.ParamConverter;

import java.time.LocalDate;

public class LocalDateParamConverter implements ParamConverter {
    @Override
    public Object fromString(String value) {
        if (value.equals("today")) {
            return LocalDate.now();
        }
        else if(value.equals("tomorrow")) {
            return LocalDate.now().plusDays(1);
        }
        else if(value.equals("yesterday")) {
            return LocalDate.now().minusDays(1);
        }

        return null;
    }

    @Override
    public String toString(Object value) {
        return value.toString();
    }
}
