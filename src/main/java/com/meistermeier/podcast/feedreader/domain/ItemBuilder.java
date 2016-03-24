package com.meistermeier.podcast.feedreader.domain;

import com.meistermeier.podcast.feedreader.common.FeedParserException;

import java.time.LocalDateTime;

public class ItemBuilder implements TitleProvider, LinkProvider, DateProvider, DescriptionProvider, EnclosureProvider {

    private String title;
    private String link;
    private LocalDateTime pubDate;
    private String description;
    private Enclosure enclosure;

    public Item build() throws FeedParserException {
        checkRequiredFields(title, description);
        return new Item(title, link, pubDate, description, enclosure);
    }

    private void checkRequiredFields(String title, String description) throws FeedParserException {
        if (title == null && description == null) {
            throw new FeedParserException("Title and description are null. At least one of both must be present.");
        }
    }

    @Override
    public ItemBuilder title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public ItemBuilder link(String link) {
        this.link = link;
        return this;
    }

    @Override
    public ItemBuilder date(LocalDateTime date) {
        this.pubDate = date;
        return this;
    }

    @Override
    public ItemBuilder description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public ItemBuilder enclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
        return this;
    }
}
