package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.Channel;
import org.w3c.dom.Element;

import java.io.InputStream;

public class PodcastFeed {

    public Channel getChannel(InputStream feedStream) throws FeedParserException {
        // http://cyber.law.harvard.edu/rss/rss.html there must be only one channel element
        Element firstChild = new FeedDocumentParser(feedStream).getFirstFunctionalChild();
        return ChannelParser.createChannel(firstChild);

    }
}
