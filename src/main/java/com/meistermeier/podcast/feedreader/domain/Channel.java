package com.meistermeier.podcast.feedreader.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Channel {
    private final String title;
    private final String link;
    private final String description;
    private final LocalDateTime lastBuildDate;
    private final ChannelImage channelImage;
    private final List<Item> items;

    Channel(String title, String link, String description, LocalDateTime lastBuildDate, ChannelImage channelImage,
            List<Item> items) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.lastBuildDate = lastBuildDate;
        this.channelImage = channelImage;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getLastBuildDate() {
        return lastBuildDate;
    }

    public ChannelImage getChannelImage() {
        return channelImage;
    }

    public List<Item> getItems() {
        return items;
    }

}
