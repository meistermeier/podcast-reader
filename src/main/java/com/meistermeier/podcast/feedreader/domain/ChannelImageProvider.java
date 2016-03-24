package com.meistermeier.podcast.feedreader.domain;

public interface ChannelImageProvider<T> {
    T channelImage(ChannelImage channelImage);
}
