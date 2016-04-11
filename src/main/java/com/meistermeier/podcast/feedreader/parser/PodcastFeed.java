package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.Channel;
import org.w3c.dom.Element;

import java.io.InputStream;

/**
 * "Main" class for parsing a podcast rss file.<br/>
 * Yes, you will use this file to get started. :)
 */
public class PodcastFeed {

    /**
     * Parses the podcast input stream.<br/>
     * Expects the file to be in proper rss format.
     * @param feedStream the podcast rss feed
     * @return the whole channel tree to be processed by the consumer
     * @throws FeedParserException if the parsing fails at a technical or semantic level a <i>FeedParserException</i>
     * will be thrown in the underlying code.
     */
    public Channel getChannel(InputStream feedStream) throws FeedParserException {
        // http://cyber.law.harvard.edu/rss/rss.html there must be only one channel element
        Element firstChild = new FeedDocumentParser(feedStream).getFirstFunctionalChild();
        return ChannelParser.newInstance().create(firstChild);
    }
}
