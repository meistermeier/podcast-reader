package com.meistermeier.podcast.feedreader.domain;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * An item represents a podcast entity/episode.
 */
public class Item {

    private final String title;
    private final String link;
    private final LocalDateTime pubDate;
    private final String description;
    private final Enclosure enclosure;

    Item(String title, String link, LocalDateTime pubDate, String description, Enclosure enclosure) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.description = description;
        this.enclosure = enclosure;
    }

    /**
     * The title of the episode. This could be absent, but in that case description has to have content.
     *
     * @return item title tag content
     */
    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

    /**
     * The link to the episode. Should be a URL but this is not checked.
     *
     * @return item link tag content
     */
    public Optional<String> getLink() {
        return Optional.ofNullable(link);
    }

    /**
     * Time of the episodes publication.
     *
     * @return item pubDate tag content
     */
    public Optional<LocalDateTime> getPubDate() {
        return Optional.ofNullable(pubDate);
    }

    /**
     * The description of the episode. This could be absent, but in that case title has to have content.
     *
     * @return item description tag content
     */
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    /**
     * The enclosure represents meta information and a link to the media provided within this episode.
     *
     * @return enclosure object encapsulating information about the media.
     */
    public Optional<Enclosure> getEnclosure() {
        return Optional.ofNullable(enclosure);
    }

}
