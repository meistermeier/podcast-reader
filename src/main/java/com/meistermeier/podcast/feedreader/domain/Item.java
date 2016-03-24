package com.meistermeier.podcast.feedreader.domain;

import java.time.LocalDateTime;

public class Item {

    private final String title;
    private final String link;
    private final LocalDateTime pubDate;
    private final String description;
    private final Enclosure enclosure;

    public Item(String title, String link, LocalDateTime pubDate, String description, Enclosure enclosure) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.description = description;
        this.enclosure = enclosure;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public String getDescription() {
        return description;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

}
