package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import org.w3c.dom.Node;

interface InformationProvider<T> {
    void addInformation(Node node, T builder) throws FeedParserException;
}




