package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.ChannelImageBuilder;
import com.meistermeier.podcast.feedreader.domain.attribute.UrlAttribute;

import java.util.ArrayList;
import java.util.List;

import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.LINK_PROCESSOR;
import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.TITLE_PROCESSOR;

final class ChannelImageNodeProcessors {

    private static final NodeProcessor<UrlAttribute> URL_PROCESSOR = (node, builder) -> {
        if ("url".equals(node.getNodeName())) {
            builder.url(node.getTextContent());
        }
    };

    final static List<NodeProcessor<? super ChannelImageBuilder>> PROCESSORS = new ArrayList<>();

    static {
        PROCESSORS.add(TITLE_PROCESSOR);
        PROCESSORS.add(LINK_PROCESSOR);
        PROCESSORS.add(URL_PROCESSOR);
    }

    private ChannelImageNodeProcessors() {

    }

}
