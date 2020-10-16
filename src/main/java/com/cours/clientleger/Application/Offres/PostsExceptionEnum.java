package com.cours.clientleger.Application.Offres;

public enum PostsExceptionEnum {
    ID_EMPTY("The id is empty");

    private String FName;

    PostsExceptionEnum(String FName) {
        this.FName = FName;
    }

    public String getFName() {
        return this.FName;
    }
}
