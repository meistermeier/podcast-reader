package com.meistermeier.podcast.feedreader.domain;

import com.meistermeier.podcast.feedreader.common.FeedParserException;

public interface Builder<D> {

    D build() throws FeedParserException;

}
