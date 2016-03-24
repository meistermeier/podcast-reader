package com.meistermeier.podcast.feedreader.domain;

public interface ItemProvider<T> {
    T item(Item item);
}
