package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.Builder;
import org.w3c.dom.Node;

import java.util.List;

abstract class Parser<B extends Builder<D>, D> {

    D create(Node node) throws FeedParserException {
        NodeProcessors.processNode(node, getBuilder(), getNodeProcessors());
        return getBuilder().build();
    }

    abstract List<NodeProcessor<? super B>> getNodeProcessors();

    abstract B getBuilder();
}
