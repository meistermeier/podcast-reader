package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.ChannelImage;
import com.meistermeier.podcast.feedreader.domain.ChannelImageBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

final class ChannelImageParser {

    private ChannelImageParser() {

    }

    static ChannelImage createChannelImage(Node imageNode) throws FeedParserException {
        ChannelImageBuilder builder = new ChannelImageBuilder();
        NodeList childNodes = imageNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            for (InformationProvider provider : ChannelImageInformationProviders.CHANNEL_IMAGE_INFORMATION_PROVIDERS) {
                provider.addInformation(item, builder);
            }
        }
        return builder.build();
    }

}
