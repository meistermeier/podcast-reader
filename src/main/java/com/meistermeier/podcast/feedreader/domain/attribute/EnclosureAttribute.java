package com.meistermeier.podcast.feedreader.domain.attribute;

public interface EnclosureAttribute<T> {
    T enclosure(String url, String length, String type);
}
