package com.example.demo.model;

/**
 * Created by ds on 2019-06-11 오후 1:36.
 */

public class Content {

    private String url;
    private String directory;
    private String title;

    public Content() {
    }

    public Content(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}