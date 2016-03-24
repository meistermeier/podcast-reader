package com.meistermeier.podcast.feedreader.domain;

public interface UrlProvider<T> {
    T url(String url);
}
