package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.ChannelImageBuilder;
import com.meistermeier.podcast.feedreader.domain.attribute.UrlAttribute;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

final class ChannelImageNodeProcessors {

    private static final class UrlProcessor implements NodeProcessor<UrlAttribute> {
        @Override
        public void process(Node node, UrlAttribute builder) throws FeedParserException {
            if ("url".equals(node.getNodeName())) {
                builder.url(node.getTextContent());
            }
        }
    }

    final static List<NodeProcessor<? super ChannelImageBuilder>> PROCESSORS = new ArrayList<>();

    static {
        PROCESSORS.add(new NodeProcessors.TitleProcessor());
        PROCESSORS.add(new NodeProcessors.LinkProcessor());
        PROCESSORS.add(new UrlProcessor());
    }

    private ChannelImageNodeProcessors() {

    }

}
