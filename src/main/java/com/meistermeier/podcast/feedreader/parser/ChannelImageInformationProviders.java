package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.ChannelImageBuilder;
import com.meistermeier.podcast.feedreader.domain.UrlProvider;

import static com.meistermeier.podcast.feedreader.parser.InformationProviders.LINK_PROVIDER;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.TITLE_PROVIDER;

final class ChannelImageInformationProviders {

    private static final InformationProvider<UrlProvider> URL_PROVIDER = (node, builder) -> {
        if ("url".equals(node.getNodeName())) {
            builder.url(node.getTextContent());
        }
    };

    static final ParserCollection<ChannelImageBuilder> PARSERS = new ParserCollection<>();

    static {
        PARSERS.add(TITLE_PROVIDER);
        PARSERS.add(LINK_PROVIDER);
        PARSERS.add(URL_PROVIDER);
    }

    private ChannelImageInformationProviders() {

    }

}
