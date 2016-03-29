package com.meistermeier.podcast.feedreader.domain.attribute;

import java.time.LocalDateTime;

public interface DateAttribute<T> {
    T date(LocalDateTime date);
}
