package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Parses the feed in a technical manner without knowledge about the final domain model
 */
class FeedDocumentParser {

    private Document parsedFeed;

    FeedDocumentParser(InputStream feedStream) throws FeedParserException {
        try {
            parseFeed(feedStream);
        } catch (ParserConfigurationException | IOException | SAXException | IllegalArgumentException e) {
            throw new FeedParserException("something went wrong while parsing the feed.", e);
        }
    }

    Element getFirstFunctionalChild() {
        return (Element) parsedFeed.getDocumentElement().getFirstChild().getNextSibling();
    }

    private void parseFeed(InputStream feedStream) throws ParserConfigurationException, IOException, SAXException {
        parsedFeed = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(feedStream);
    }

}
