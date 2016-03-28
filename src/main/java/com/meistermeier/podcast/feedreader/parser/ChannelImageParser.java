package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.ChannelImage;
import com.meistermeier.podcast.feedreader.domain.ChannelImageBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static com.meistermeier.podcast.feedreader.parser.ChannelImageInformationProviders.PARSERS;

final class ChannelImageParser {

    private ChannelImageParser() {

    }

    static ChannelImage createChannelImage(Node imageNode) throws FeedParserException {
        ChannelImageBuilder builder = new ChannelImageBuilder();
        NodeList childNodes = imageNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            for (InformationProvider<? super ChannelImageBuilder> provider : PARSERS.providers) {
                provider.addInformation(item, builder);
            }
        }
        return builder.build();
    }

}
