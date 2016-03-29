package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.ChannelImageBuilder;
import com.meistermeier.podcast.feedreader.domain.UrlProvider;

import java.util.ArrayList;
import java.util.List;

import static com.meistermeier.podcast.feedreader.parser.InformationProviders.LINK_PROVIDER;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.TITLE_PROVIDER;

final class ChannelImageInformationProviders {

    private static final InformationProvider<UrlProvider> URL_PROVIDER = (node, builder) -> {
        if ("url".equals(node.getNodeName())) {
            builder.url(node.getTextContent());
        }
    };

    final static List<InformationProvider<? super ChannelImageBuilder>> PARSERS = new ArrayList<>();

    static {
        PARSERS.add(TITLE_PROVIDER);
        PARSERS.add(LINK_PROVIDER);
        PARSERS.add(URL_PROVIDER);
    }

    private ChannelImageInformationProviders() {

    }

}
