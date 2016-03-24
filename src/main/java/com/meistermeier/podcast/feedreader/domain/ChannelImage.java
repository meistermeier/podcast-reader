package com.meistermeier.podcast.feedreader.domain;

public class ChannelImage {
    private final String url;
    private final String title;
    private final String link;

    public ChannelImage(String url, String title, String link) {
        this.url = url;
        this.title = title;
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

}
