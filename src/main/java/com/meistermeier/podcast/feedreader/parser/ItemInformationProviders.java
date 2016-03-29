package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.EnclosureProvider;
import com.meistermeier.podcast.feedreader.domain.ItemBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.meistermeier.podcast.feedreader.parser.InformationProviders.DATE_PROVIDER;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.DESCRIPTION_PROVIDER;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.LINK_PROVIDER;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.TITLE_PROVIDER;

final class ItemInformationProviders {

    private static final InformationProvider<EnclosureProvider> ENCLOSURE_PROVIDER = (node, builder) -> {
        if ("enclosure".equals(node.getNodeName())) {
            String url = node.getAttributes().getNamedItem("url").getTextContent();
            String length = node.getAttributes().getNamedItem("length").getTextContent();
            String type = node.getAttributes().getNamedItem("type").getTextContent();
            builder.enclosure(url, length, type);
        }
    };

    final static List<InformationProvider<? super ItemBuilder>> PARSERS = new ArrayList<>();

    static {
        PARSERS.add(TITLE_PROVIDER);
        PARSERS.add(DESCRIPTION_PROVIDER);
        PARSERS.add(DATE_PROVIDER);
        PARSERS.add(LINK_PROVIDER);
        PARSERS.add(ENCLOSURE_PROVIDER);
    }

    private ItemInformationProviders() {

    }
}
