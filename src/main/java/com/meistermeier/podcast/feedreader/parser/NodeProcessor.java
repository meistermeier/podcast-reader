package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import org.w3c.dom.Node;

interface NodeProcessor<T> {
    void process(Node node, T builder) throws FeedParserException;
}




