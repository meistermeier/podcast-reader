package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.DateProvider;
import com.meistermeier.podcast.feedreader.domain.DescriptionProvider;
import com.meistermeier.podcast.feedreader.domain.LinkProvider;
import com.meistermeier.podcast.feedreader.domain.TitleProvider;

final class InformationProviders {

    private InformationProviders() {

    }

    static InformationProvider<TitleProvider> titleProvider = (node, builder) -> {
        if ("title".equals(node.getNodeName())) {
            builder.title(node.getTextContent());
        }
    };

    static InformationProvider<DescriptionProvider> descriptionProvider = (node, builder) -> {
        if ("description".equals(node.getNodeName())) {
            builder.description(node.getTextContent());
        }
    };

    static InformationProvider<DateProvider> dateProvider = (node, builder) -> {
        if ("lastBuildDate".equals(node.getNodeName()) || "pubDate".equals(node.getNodeName())) {
            builder.date(PodcastDate.parsePodcastDate(node.getTextContent()));
        }
    };

    static InformationProvider<LinkProvider> linkProvider = (node, builder) -> {
        if ("link".equals(node.getNodeName())) {
            builder.link(node.getTextContent());
        }
    };

}

