package com.meistermeier.podcast.feedreader.domain;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.attribute.DateAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.DescriptionAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.EnclosureAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.LinkAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.TitleAttribute;

import java.time.LocalDateTime;

public class ItemBuilder implements TitleAttribute, LinkAttribute, DateAttribute, DescriptionAttribute,
        EnclosureAttribute {

    private String title;
    private String link;
    private LocalDateTime pubDate;
    private String description;
    private Enclosure enclosure;

    public Item build() throws FeedParserException {
        checkRequiredFields();
        return new Item(title, link, pubDate, description, enclosure);
    }

    private void checkRequiredFields() throws FeedParserException {
        if (titleAndDescriptionAreMissing(title, description)) {
            throw new FeedParserException("Title and description are null. At least one of both must be present.");
        }
        if (enclosureHasMissingFields()) {
            throw new FeedParserException("The enclosure exists but has missing fields: " + enclosure);
        }
    }

    private boolean enclosureHasMissingFields() {
        return enclosure != null
                && (enclosure.getLength() == null || enclosure.getUrl() == null || enclosure.getType() == null);
    }

    private boolean titleAndDescriptionAreMissing(String title, String description) {
        return title == null && description == null;
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
    public ItemBuilder enclosure(String url, String length, String type) {
        this.enclosure = new Enclosure(url, length, type);
        return this;
    }
}
