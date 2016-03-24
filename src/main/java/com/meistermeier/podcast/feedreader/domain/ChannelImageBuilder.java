package com.meistermeier.podcast.feedreader.domain;

public class ChannelImageBuilder implements TitleProvider, LinkProvider, UrlProvider {
    private String url;
    private String title;
    private String link;

    public ChannelImage build() {
        return new ChannelImage(url, title, link);
    }

    @Override
    public ChannelImageBuilder link(String link) {
        this.link = link;
        return this;
    }

    @Override
    public ChannelImageBuilder title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public ChannelImageBuilder url(String url) {
        this.url = url;
        return this;
    }
}
