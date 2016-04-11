package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.attribute.DateAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.DescriptionAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.LinkAttribute;
import com.meistermeier.podcast.feedreader.domain.attribute.TitleAttribute;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

final class NodeProcessors {

    private NodeProcessors() {

    }

    static final class TitleProcessor implements NodeProcessor<TitleAttribute> {
        @Override
        public void process(Node node, TitleAttribute builder) throws FeedParserException {
            if ("title".equals(node.getNodeName())) {
                builder.title(node.getTextContent());
            }
        }
    }

    static final class DescriptionProcessor implements NodeProcessor<DescriptionAttribute>  {
        @Override
        public void process(Node node, DescriptionAttribute builder) throws FeedParserException {
            if ("description".equals(node.getNodeName())) {
                builder.description(node.getTextContent());
            }
        }
    }

    static final class DateProcessor implements NodeProcessor<DateAttribute>{
        @Override
        public void process(Node node, DateAttribute builder) throws FeedParserException {
            if ("lastBuildDate".equals(node.getNodeName()) || "pubDate".equals(node.getNodeName())) {
                builder.date(PodcastDate.parsePodcastDate(node.getTextContent()));
            }
        }
    }

    static final class LinkProcessor implements NodeProcessor<LinkAttribute> {
        @Override
        public void process(Node node, LinkAttribute builder) throws FeedParserException {
            if ("link".equals(node.getNodeName())) {
                builder.link(node.getTextContent());
            }
        }
    }

    static <T> void processNode(Node node, T builder, List<NodeProcessor<? super T>> processors)
            throws FeedParserException {

        NodeList childNodes = node.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            for (NodeProcessor<? super T> processor : processors) {
                processor.process(item, builder);
            }
        }
    }
}
