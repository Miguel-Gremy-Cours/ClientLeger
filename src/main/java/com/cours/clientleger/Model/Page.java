package com.cours.clientleger.Model;

public class Page {
    private String title;

    private String pagePath;

    //region Getter Setters

    public String getTitle() {
        return title;
    }

    public Page setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPagePath() {
        return pagePath;
    }

    public Page setPagePath(String pagePath) {
        this.pagePath = pagePath;
        return this;
    }

    //endregion

}
