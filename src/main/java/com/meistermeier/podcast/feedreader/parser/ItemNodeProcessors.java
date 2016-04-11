package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.attribute.EnclosureAttribute;
import com.meistermeier.podcast.feedreader.domain.ItemBuilder;
import com.meistermeier.podcast.feedreader.parser.NodeProcessors.DateProcessor;
import com.meistermeier.podcast.feedreader.parser.NodeProcessors.DescriptionProcessor;
import com.meistermeier.podcast.feedreader.parser.NodeProcessors.TitleProcessor;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

import static com.meistermeier.podcast.feedreader.parser.NodeProcessors.*;

final class ItemNodeProcessors {

    private static final class EnclosureProcessor implements NodeProcessor<EnclosureAttribute> {
        @Override
        public void process(Node node, EnclosureAttribute builder) throws FeedParserException {
            if ("enclosure".equals(node.getNodeName())) {
                String url = node.getAttributes().getNamedItem("url").getTextContent();
                String length = node.getAttributes().getNamedItem("length").getTextContent();
                String type = node.getAttributes().getNamedItem("type").getTextContent();
                builder.enclosure(url, length, type);
            }
        }
    }

    final static List<NodeProcessor<? super ItemBuilder>> PARSERS = new ArrayList<>();

    static {
        PARSERS.add(new TitleProcessor());
        PARSERS.add(new DescriptionProcessor());
        PARSERS.add(new DateProcessor());
        PARSERS.add(new LinkProcessor());
        PARSERS.add(new EnclosureProcessor());
    }

    private ItemNodeProcessors() {

    }
}
