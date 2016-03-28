package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.Item;
import com.meistermeier.podcast.feedreader.domain.ItemBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static com.meistermeier.podcast.feedreader.parser.ItemInformationProviders.PARSERS;

final class ItemParser {

    private ItemParser() {

    }

    static Item createItem(Node node) throws FeedParserException {
        ItemBuilder itemBuilder = new ItemBuilder();

        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            for (InformationProvider<? super ItemBuilder> informationProvider : PARSERS.providers) {
                informationProvider.addInformation(item, itemBuilder);
            }
        }

        return itemBuilder.build();
    }

}
