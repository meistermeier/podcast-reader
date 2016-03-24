package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.UrlProvider;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.meistermeier.podcast.feedreader.parser.InformationProviders.linkProvider;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.titleProvider;

final class ChannelImageInformationProviders {

    private ChannelImageInformationProviders() {

    }

    static InformationProvider<UrlProvider> urlProvider = (node, builder) -> {
        if ("url".equals(node.getNodeName())) {
            builder.url(node.getTextContent());
        }
    };

    static Set<InformationProvider> CHANNEL_IMAGE_INFORMATION_PROVIDERS = Collections.unmodifiableSet(
            Stream.of(titleProvider,
                    linkProvider,
                    urlProvider)
                    .collect(Collectors.toSet()));

}
