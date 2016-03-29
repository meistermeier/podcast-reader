package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.Item;
import com.meistermeier.podcast.feedreader.domain.ItemBuilder;
import org.w3c.dom.Node;

import static com.meistermeier.podcast.feedreader.parser.InformationProviders.addInformationToBuilder;
import static com.meistermeier.podcast.feedreader.parser.ItemInformationProviders.PARSERS;

final class ItemParser {

    private ItemParser() {

    }

    static Item createItem(Node node) throws FeedParserException {
        ItemBuilder builder = new ItemBuilder();

        addInformationToBuilder(node, builder, PARSERS);

        return builder.build();
    }

}
