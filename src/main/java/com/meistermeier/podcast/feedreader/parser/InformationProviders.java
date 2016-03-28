package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.DateProvider;
import com.meistermeier.podcast.feedreader.domain.DescriptionProvider;
import com.meistermeier.podcast.feedreader.domain.LinkProvider;
import com.meistermeier.podcast.feedreader.domain.TitleProvider;

final class InformationProviders {

    private InformationProviders() {

    }

    static final InformationProvider<TitleProvider> TITLE_PROVIDER = (node, builder) -> {
        if ("title".equals(node.getNodeName())) {
            builder.title(node.getTextContent());
        }
    };

    static final InformationProvider<DescriptionProvider> DESCRIPTION_PROVIDER = (node, builder) -> {
        if ("description".equals(node.getNodeName())) {
            builder.description(node.getTextContent());
        }
    };

    static final InformationProvider<DateProvider> DATE_PROVIDER = (node, builder) -> {
        if ("lastBuildDate".equals(node.getNodeName()) || "pubDate".equals(node.getNodeName())) {
            builder.date(PodcastDate.parsePodcastDate(node.getTextContent()));
        }
    };

    static final InformationProvider<LinkProvider> LINK_PROVIDER = (node, builder) -> {
        if ("link".equals(node.getNodeName())) {
            builder.link(node.getTextContent());
        }
    };

}

