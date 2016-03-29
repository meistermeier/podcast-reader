package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.ChannelImage;
import com.meistermeier.podcast.feedreader.domain.ChannelImageBuilder;
import org.w3c.dom.Node;

import static com.meistermeier.podcast.feedreader.parser.ChannelImageNodeProcessors.PROCESSORS;
import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.processNode;

final class ChannelImageParser {

    private ChannelImageParser() {

    }

    static ChannelImage createChannelImage(Node node) throws FeedParserException {
        ChannelImageBuilder builder = new ChannelImageBuilder();

        processNode(node, builder, PROCESSORS);

        return builder.build();
    }


}
