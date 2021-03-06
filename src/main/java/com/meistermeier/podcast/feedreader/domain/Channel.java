package com.meistermeier.podcast.feedreader.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Channel {
    private final String title;
    private final String link;
    private final String description;
    private final LocalDateTime lastBuildDate;
    private final ChannelImage channelImage;
    private final List<Item> items = new ArrayList<>();

    Channel(String title, String link, String description,
            LocalDateTime lastBuildDate, ChannelImage channelImage, List<Item> items) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.lastBuildDate = lastBuildDate;
        this.channelImage = channelImage;

        this.items.addAll(items != null ? items.stream().collect(Collectors.toList()) : Collections.EMPTY_LIST);
    }

    /**
     * The name of the channel.
     *
     * @return text content of the title tag.
     */
    public String getTitle() {
        return title;
    }

    /**
     * The url of the channel.
     *
     * @return text content of the link tag.
     */
    public String getLink() {
        return link;
    }

    /**
     * The descriptive text of the channel.<br/>
     * Note: The text will be returned as-is without trimming. If there are leading / trailing line breaks
     * or whitespaces they will be returned.
     *
     * @return text content of the description tag without any trims
     */
    public String getDescription() {
        return description;
    }

    /**
     * The time of the last generation of the channel.<br/>
     * That does not necessary mean that content in there really changed.
     *
     * @return time of the feed generation
     */
    public Optional<LocalDateTime> getLastBuildDate() {
        return Optional.ofNullable(lastBuildDate);
    }

    /**
     * The provided channel image object containing at least image, url and link.
     *
     * @return channel image object with all provided attributes
     */
    public Optional<ChannelImage> getChannelImage() {
        return Optional.ofNullable(channelImage);
    }

    /**
     * All items in the channel. Each item represents a single podcast entity / episode.
     *
     * @return items in the channel
     */
    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", lastBuildDate=" + lastBuildDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Channel channel = (Channel) o;

        if (!title.equals(channel.title))
            return false;
        if (!link.equals(channel.link))
            return false;
        return description.equals(channel.description);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + link.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
