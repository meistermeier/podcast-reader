package com.meistermeier.podcast.feedreader.domain;

public interface LinkProvider<T> {
    T link(String link);
}
