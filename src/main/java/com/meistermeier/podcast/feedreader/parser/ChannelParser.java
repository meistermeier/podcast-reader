package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.Channel;
import com.meistermeier.podcast.feedreader.domain.ChannelBuilder;
import org.w3c.dom.Node;

import static com.meistermeier.podcast.feedreader.parser.ChannelNodeProcessors.PROCESSORS;
import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.processNode;

final class ChannelParser {

    private ChannelParser() {

    }

    static Channel createChannel(Node node) throws FeedParserException {

        ChannelBuilder builder = new ChannelBuilder();

        processNode(node, builder, PROCESSORS);

        return builder.build();
    }

}
