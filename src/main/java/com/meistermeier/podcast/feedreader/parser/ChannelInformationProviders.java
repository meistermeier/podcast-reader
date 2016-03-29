package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.ChannelBuilder;
import com.meistermeier.podcast.feedreader.domain.ChannelImageProvider;
import com.meistermeier.podcast.feedreader.domain.ItemProvider;

import java.util.ArrayList;
import java.util.List;

import static com.meistermeier.podcast.feedreader.parser.InformationProviders.DATE_PROVIDER;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.DESCRIPTION_PROVIDER;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.LINK_PROVIDER;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.TITLE_PROVIDER;

final class ChannelInformationProviders {

    private static final InformationProvider<ChannelImageProvider> CHANNEL_IMAGE_PROVIDER = (node, builder) -> {
        if ("image".equals(node.getNodeName())) {
            builder.channelImage(ChannelImageParser.createChannelImage(node));
        }
    };

    private static final InformationProvider<ItemProvider> ITEM_PROVIDER = (node, builder) -> {
        if ("item".equals(node.getNodeName())) {
            builder.item(ItemParser.createItem(node));
        }
    };

    final static List<InformationProvider<? super ChannelBuilder>> PARSERS = new ArrayList<>();

    static {
        PARSERS.add(TITLE_PROVIDER);
        PARSERS.add(DESCRIPTION_PROVIDER);
        PARSERS.add(DATE_PROVIDER);
        PARSERS.add(LINK_PROVIDER);
        PARSERS.add(ITEM_PROVIDER);
        PARSERS.add(CHANNEL_IMAGE_PROVIDER);
    }

    private ChannelInformationProviders() {

    }
}
