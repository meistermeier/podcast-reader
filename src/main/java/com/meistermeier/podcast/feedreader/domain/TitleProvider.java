package com.meistermeier.podcast.feedreader.domain;

public interface TitleProvider<T> {
    T title(String title);
}
