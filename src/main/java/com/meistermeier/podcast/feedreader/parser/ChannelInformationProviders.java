package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.ChannelImageProvider;
import com.meistermeier.podcast.feedreader.domain.ItemProvider;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.meistermeier.podcast.feedreader.parser.InformationProviders.dateProvider;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.descriptionProvider;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.linkProvider;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.titleProvider;

final class ChannelInformationProviders {

    private ChannelInformationProviders() {

    }

    static InformationProvider<ChannelImageProvider> channelImageProvider = (node, builder) -> {
        if ("image".equals(node.getNodeName())) {
            builder.channelImage(ChannelImageParser.createChannelImage(node));
        }
    };
    static InformationProvider<ItemProvider> itemProvider = (node, builder) -> {
        if ("item".equals(node.getNodeName())) {
            builder.item(ItemParser.createItem(node));
        }
    };

    static Set<InformationProvider> CHANNEL_INFORMATION_PROVIDERS = Collections.unmodifiableSet(
            Stream.of(titleProvider,
                    descriptionProvider,
                    dateProvider,
                    linkProvider,
                    itemProvider,
                    channelImageProvider)
                    .collect(Collectors.toSet()));

}
