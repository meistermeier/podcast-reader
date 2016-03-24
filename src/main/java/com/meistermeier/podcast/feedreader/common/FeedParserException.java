package com.meistermeier.podcast.feedreader.common;

public class FeedParserException extends Exception {
    public FeedParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeedParserException(String message) {
        super(message);
    }
}
