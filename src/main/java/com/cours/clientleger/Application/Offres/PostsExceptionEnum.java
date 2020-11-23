package com.cours.clientleger.Application.Offres;

public enum PostsExceptionEnum {
    ID_EMPTY("The id is empty");

    private String FName;

    /**
     * Function that link the full error String to short Error String
     *
     * @param FName The full Error String
     */
    PostsExceptionEnum(String FName) {
        this.FName = FName;
    }

    /**
     * Function that return the fulll Error String of Error
     */
    public String getFName() {
        return this.FName;
    }
}
