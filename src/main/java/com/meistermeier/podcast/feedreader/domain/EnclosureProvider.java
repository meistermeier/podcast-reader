package com.meistermeier.podcast.feedreader.domain;

public interface EnclosureProvider<T> {
    T enclosure(Enclosure enclosure);
}
