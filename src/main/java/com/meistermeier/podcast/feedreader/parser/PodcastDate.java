package com.meistermeier.podcast.feedreader.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

final class PodcastDate {

    private PodcastDate() {

    }

    private static final String DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss Z";

    public static LocalDateTime parsePodcastDate(String podcastDateString) {
        return LocalDateTime.parse(podcastDateString, DateTimeFormatter.ofPattern(DATE_PATTERN, Locale.ENGLISH));
    }
}
