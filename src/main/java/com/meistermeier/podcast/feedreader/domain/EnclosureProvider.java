package com.meistermeier.podcast.feedreader.domain;

public interface EnclosureProvider<T> {
    T enclosure(String url, String length, String type);
}
