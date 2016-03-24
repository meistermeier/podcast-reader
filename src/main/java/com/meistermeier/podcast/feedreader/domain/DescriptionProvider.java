package com.meistermeier.podcast.feedreader.domain;

public interface DescriptionProvider<T> {
    T description(String description);
}
