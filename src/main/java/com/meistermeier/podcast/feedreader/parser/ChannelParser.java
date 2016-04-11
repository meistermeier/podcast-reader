package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.Channel;
import com.meistermeier.podcast.feedreader.domain.ChannelBuilder;
import com.meistermeier.podcast.feedreader.domain.attribute.ChannelImageAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.ItemAttribute;
import com.meistermeier.podcast.feedreader.parser.NodeProcessors.DateProcessor;
import com.meistermeier.podcast.feedreader.parser.NodeProcessors.DescriptionProcessor;
import com.meistermeier.podcast.feedreader.parser.NodeProcessors.LinkProcessor;
import com.meistermeier.podcast.feedreader.parser.NodeProcessors.TitleProcessor;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

final class ChannelParser extends Parser<ChannelBuilder, Channel> {

    private static final class ChannelImageProcessor implements NodeProcessor<ChannelImageAttribute>  {
        @Override
        public void process(Node node, ChannelImageAttribute builder) throws FeedParserException {
            if ("image".equals(node.getNodeName())) {
                builder.channelImage(ChannelImageParser.createChannelImage(node));
            }
        }
    }

    private static final class ItemProcessor implements NodeProcessor<ItemAttribute> {
        @Override
        public void process(Node node, ItemAttribute builder) throws FeedParserException {
            if ("item".equals(node.getNodeName())) {
                builder.item(ItemParser.createItem(node));
            }
        }
    }

    private final List<NodeProcessor<? super ChannelBuilder>> processors = new ArrayList<>();

    private final ChannelBuilder channelBuilder;

    private ChannelParser() {
        channelBuilder = new ChannelBuilder();
        initializeProcessors();
    }

    private void initializeProcessors() {
        processors.add(new TitleProcessor());
        processors.add(new DescriptionProcessor());
        processors.add(new DateProcessor());
        processors.add(new LinkProcessor());
        processors.add(new ItemProcessor());
        processors.add(new ChannelImageProcessor());
    }

    static ChannelParser newInstance() {
        return new ChannelParser();
    }

    @Override
    List<NodeProcessor<? super ChannelBuilder>> getNodeProcessors() {
        return processors;
    }

    @Override
    ChannelBuilder getBuilder() {
        return channelBuilder;
    }
}
