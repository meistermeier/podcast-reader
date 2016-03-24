package com.meistermeier.podcast.feedreader.parser;


import com.meistermeier.podcast.feedreader.common.FeedParserException;
import org.junit.Test;
import org.w3c.dom.Node;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FeedDocumentParserTest {

    @Test
    public void feedReaderReadsFeed() throws Exception {
        final FeedDocumentParser feedDocumentParser = new FeedDocumentParser(getClass().getResourceAsStream("/method.xml"));
        Node firstChild = feedDocumentParser.getFirstFunctionalChild();

        assertThat(firstChild.getNodeName(), equalTo("channel"));
    }

    @Test(expected = FeedParserException.class)
    public void feedReaderThrowsFeedParserExceptionIfUnknownFile() throws Exception {
        new FeedDocumentParser(getClass().getResourceAsStream("/unknown_file.xml"));
    }

    @Test(expected = FeedParserException.class)
    public void feedReaderThrowsFeedParserExceptionIfBrokenFile() throws Exception {
        new FeedDocumentParser(getClass().getResourceAsStream("/broken.xml"));
    }
}
