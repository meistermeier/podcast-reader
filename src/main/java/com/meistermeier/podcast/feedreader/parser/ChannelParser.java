package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.Channel;
import com.meistermeier.podcast.feedreader.domain.ChannelBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

final class ChannelParser {

    private ChannelParser() {

    }

    static Channel createChannel(Element channelElement) throws FeedParserException {

        ChannelBuilder channelBuilder = new ChannelBuilder();

        NodeList childNodes = channelElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            for (InformationProvider<? super ChannelBuilder> provider : ChannelInformationProviders.PARSERS.providers) {
                provider.addInformation(item, channelBuilder);
            }

        }

        return channelBuilder.build();
    }

}
