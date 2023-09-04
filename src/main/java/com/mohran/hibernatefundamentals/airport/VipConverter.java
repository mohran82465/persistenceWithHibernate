package com.mohran.hibernatefundamentals.airport;

import javax.persistence.AttributeConverter;

public class VipConverter implements AttributeConverter<Boolean,String> {

    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return aBoolean? "Yes":"No";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Yes".equalsIgnoreCase(dbData) ?
                Boolean.TRUE: Boolean.FALSE;
    }
}
