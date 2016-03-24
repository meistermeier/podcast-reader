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

    @Override
    public String toString() {
        return "Enclosure{" +
                "url='" + url + '\'' +
                ", length='" + length + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Enclosure enclosure = (Enclosure) o;

        if (!url.equals(enclosure.url))
            return false;
        if (!length.equals(enclosure.length))
            return false;
        return type.equals(enclosure.type);

    }

    @Override
    public int hashCode() {
        int result = url.hashCode();
        result = 31 * result + length.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
