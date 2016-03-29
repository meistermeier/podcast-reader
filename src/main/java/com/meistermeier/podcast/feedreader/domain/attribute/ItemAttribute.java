package com.meistermeier.podcast.feedreader.domain.attribute;

import com.meistermeier.podcast.feedreader.domain.Item;

public interface ItemAttribute<T> {
    T item(Item item);
}
