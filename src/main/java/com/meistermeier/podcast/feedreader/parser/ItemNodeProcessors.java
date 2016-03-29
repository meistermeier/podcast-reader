package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.attribute.EnclosureAttribute;
import com.meistermeier.podcast.feedreader.domain.ItemBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.DATE_PROCESSOR;
import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.DESCRIPTION_PROCESSOR;
import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.LINK_PROCESSOR;
import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.TITLE_PROCESSOR;

final class ItemNodeProcessors {

    private static final NodeProcessor<EnclosureAttribute> ENCLOSURE_PROCESSOR = (node, builder) -> {
        if ("enclosure".equals(node.getNodeName())) {
            String url = node.getAttributes().getNamedItem("url").getTextContent();
            String length = node.getAttributes().getNamedItem("length").getTextContent();
            String type = node.getAttributes().getNamedItem("type").getTextContent();
            builder.enclosure(url, length, type);
        }
    };

    final static List<NodeProcessor<? super ItemBuilder>> PARSERS = new ArrayList<>();

    static {
        PARSERS.add(TITLE_PROCESSOR);
        PARSERS.add(DESCRIPTION_PROCESSOR);
        PARSERS.add(DATE_PROCESSOR);
        PARSERS.add(LINK_PROCESSOR);
        PARSERS.add(ENCLOSURE_PROCESSOR);
    }

    private ItemNodeProcessors() {

    }
}
