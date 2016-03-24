package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.Item;
import com.meistermeier.podcast.feedreader.domain.ItemBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

final class ItemParser {

    private ItemParser() {

    }

    static Item createItem(Node node) throws FeedParserException {
        ItemBuilder itemBuilder = new ItemBuilder();

        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            for (InformationProvider informationProvider : ItemInformationProviders.ITEM_INFORMATION_PROVIDERS) {
                informationProvider.addInformation(item, itemBuilder);
            }
        }

        return itemBuilder.build();
    }

}
