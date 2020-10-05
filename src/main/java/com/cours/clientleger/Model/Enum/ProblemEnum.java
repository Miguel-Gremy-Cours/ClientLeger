package com.cours.clientleger.Model.Enum;

public enum ProblemEnum {
    LAST_NAME("Last name is empty"),
    FIRST_NAME("First name is empty"),
    CIVILITE("Civility is not correct"),
    BIRTH_DATE("Birth date is empty"),
    LOGIN("Login is empty"),
    PASSWORD("Password is empty"),
    EMAIL("Email is not correct"),
    EMAIL_EMPTY("Email is empty"),
    ERROR_LOGIN("Login or password incorrect.");

    private String FName;

    ProblemEnum(String FName) {
        this.FName = FName;
    }

    public String getFName() {
        return this.FName;
    }
}
