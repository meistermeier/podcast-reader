package com.meistermeier.podcast.feedreader.domain;

/**
 * Enclosure element representing the media of an episode
 */
public class Enclosure {
    private final String url;
    private final String length;
    private final String type;

    Enclosure(String url, String length, String type) {
        this.url = url;
        this.length = length;
        this.type = type;
    }

    /**
     * http url to the provided media. It should be http but it is not checked.
     *
     * @return url of the media
     */
    public String getUrl() {
        return url;
    }

    /**
     * file length of the media behind the url.
     *
     * @return length in bytes
     */
    public String getLength() {
        return length;
    }

    /**
     * MIME type of the media
     *
     * @return type of media
     */
    public String getType() {
        return type;
    }

}
