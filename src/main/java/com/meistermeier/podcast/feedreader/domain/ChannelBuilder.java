package com.meistermeier.podcast.feedreader.domain;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.attribute.ChannelImageAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.DateAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.DescriptionAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.ItemAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.LinkAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.TitleAttribute;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChannelBuilder
        implements TitleAttribute, LinkAttribute, DescriptionAttribute, DateAttribute, ItemAttribute,
        ChannelImageAttribute, Builder<Channel> {
    private String title;
    private String link;
    private String description;
    private LocalDateTime lastBuildDate;
    private ChannelImage channelImage;
    private List<Item> items = new ArrayList<>();

    public Channel build() throws FeedParserException {
        checkRequiredFields(title, link, description);
        return new Channel(title, link, description, lastBuildDate, channelImage, items);
    }

    private void checkRequiredFields(String title, String link, String description) throws FeedParserException {
        if (title == null) {
            throw new FeedParserException("title must not be null.");
        }
        if (link == null) {
            throw new FeedParserException("link must not be null.");
        }
        if (description == null) {
            throw new FeedParserException("description must not be null.");
        }
    }

    public ChannelBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ChannelBuilder link(String link) {
        this.link = link;
        return this;
    }

    public ChannelBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ChannelBuilder date(LocalDateTime date) {
        this.lastBuildDate = date;
        return this;
    }

    public ChannelBuilder channelImage(ChannelImage channelImage) {
        this.channelImage = channelImage;
        return this;
    }

    public ChannelBuilder item(Item item) {
        items.add(item);
        return this;
    }
}
