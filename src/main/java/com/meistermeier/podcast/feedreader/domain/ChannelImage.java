package com.meistermeier.podcast.feedreader.domain;

/**
 * ChannelImage represents the image of the channel
 */
public class ChannelImage {
    private final String url;
    private final String title;
    private final String link;

    ChannelImage(String url, String title, String link) {
        this.url = url;
        this.title = title;
        this.link = link;
    }

    /**
     * The url that points to a gif, jpeg or png picture.<br/>
     * The image format is not checked and it might be possible to get some arbitrary url.
     *
     * @return thr url pointing to the channel image
     */
    public String getUrl() {
        return url;
    }

    /**
     * The title of the image. May be used to display image information if it is not possible to show the image.
     *
     * @return placeholder text for the image
     */
    public String getTitle() {
        return title;
    }

    /**
     * The url the image should point at. Mostly it is the same as the link of the channel.
     *
     * @return underlying link to the channel
     */
    public String getLink() {
        return link;
    }

}
