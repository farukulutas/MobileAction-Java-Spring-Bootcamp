package com.farukulutas.demo.gen.enums;

import com.farukulutas.demo.gen.exceptions.BaseErrorMessage;

public enum GenErrorMessage implements BaseErrorMessage {

    ITEM_NOT_FOUND("Item not found!"),
    PARAMETER_CANNOT_BE_NULL("Parameter cannot be null"),
    CHAR_COUNT_CANNOT_BE_ZERO_OR_NEGATIVE("Char count cannot be zero or negative!"),
    DATE_COULD_NOT_BE_CONVERTED("Date could not be converted!")
    ;

    private String message;

    GenErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
