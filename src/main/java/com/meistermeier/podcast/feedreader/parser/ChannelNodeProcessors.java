package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.ChannelBuilder;
import com.meistermeier.podcast.feedreader.domain.attribute.ChannelImageAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.ItemAttribute;

import java.util.ArrayList;
import java.util.List;

import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.DATE_PROCESSOR;
import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.DESCRIPTION_PROCESSOR;
import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.LINK_PROCESSOR;
import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.TITLE_PROCESSOR;

final class ChannelNodeProcessors {

    private static final NodeProcessor<ChannelImageAttribute> CHANNEL_IMAGE_PROCESSOR = (node, builder) -> {
        if ("image".equals(node.getNodeName())) {
            builder.channelImage(ChannelImageParser.createChannelImage(node));
        }
    };

    private static final NodeProcessor<ItemAttribute> ITEM_PROCESSOR = (node, builder) -> {
        if ("item".equals(node.getNodeName())) {
            builder.item(ItemParser.createItem(node));
        }
    };

    final static List<NodeProcessor<? super ChannelBuilder>> PROCESSORS = new ArrayList<>();

    static {
        PROCESSORS.add(TITLE_PROCESSOR);
        PROCESSORS.add(DESCRIPTION_PROCESSOR);
        PROCESSORS.add(DATE_PROCESSOR);
        PROCESSORS.add(LINK_PROCESSOR);
        PROCESSORS.add(ITEM_PROCESSOR);
        PROCESSORS.add(CHANNEL_IMAGE_PROCESSOR);
    }

    private ChannelNodeProcessors() {

    }
}
