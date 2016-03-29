package com.meistermeier.podcast.feedreader.domain;

import com.meistermeier.podcast.feedreader.domain.attribute.LinkAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.TitleAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.UrlAttribute;

public class ChannelImageBuilder implements TitleAttribute, LinkAttribute, UrlAttribute {
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
