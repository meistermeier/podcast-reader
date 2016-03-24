package com.meistermeier.podcast.feedreader.domain;

import java.time.LocalDateTime;

public interface DateProvider<T> {
    T date(LocalDateTime date);
}
