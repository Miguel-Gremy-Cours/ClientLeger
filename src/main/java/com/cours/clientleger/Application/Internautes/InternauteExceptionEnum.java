package com.cours.clientleger.Application.Internautes;

public enum InternauteExceptionEnum {
    LAST_NAME("Last name is empty"),
    FIRST_NAME("First name is empty"),
    CIVILITE("Civility is not correct"),
    BIRTH_DATE("Birth date is empty"),
    LOGIN("Login is empty"),
    LOGIN_USED("This login is already used"),
    PASSWORD("Password is empty"),
    EMAIL("Email is not correct"),
    EMAIL_EMPTY("Email is empty"),
    EMAIL_USED("This email is already used"),
    ERROR_LOGIN("Login or password incorrect."),

    INCORRECT_VALUES("Incorrect values"),
    DATA_EMPTY("Data is empty");

    private String FName;

    InternauteExceptionEnum(String FName) {
        this.FName = FName;
    }

    public String getFName() {
        return this.FName;
    }
}
