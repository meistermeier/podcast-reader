package com.meistermeier.podcast.feedreader.domain;

/**
 * Enclosure element representing the media of an episode
 */
public class Enclosure {
    private String url;
    private String length;
    private String type;

    /**
     * http url to the provided media. It should be http but it is not checked.
     *
     * @return url of the media
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * file length of the media behind the url.
     *
     * @return length in bytes
     */
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    /**
     * MIME type of the media
     *
     * @return type of media
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
