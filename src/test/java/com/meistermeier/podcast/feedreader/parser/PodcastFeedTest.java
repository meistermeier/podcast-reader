package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import com.meistermeier.podcast.feedreader.domain.Channel;
import com.meistermeier.podcast.feedreader.domain.Item;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PodcastFeedTest {

    private Channel channel;

    @Before
    public void setUp() throws Exception {
        channel = new PodcastFeed().getChannel(getClass().getResourceAsStream("/method.xml"));
    }

    @Test(expected = FeedParserException.class)
    public void damagedFileWillNotBeParsed() throws Exception {
        new PodcastFeed().getChannel(getClass().getResourceAsStream("/broken.xml"));
    }

    @Test
    public void channelHasCorrectTitle() {
        assertThat(channel.getTitle(), equalTo("Methodisch inkorrekt"));
    }

    @Test
    public void channelHasCorrectLink() {
        assertThat(channel.getLink(), equalTo("http://minkorrekt.de"));
    }

    @Test
    public void channelHasCorrectDescription() {
        assertThat(channel.getDescription(), equalTo("der methodisch inkorrekte Wissenschaftspodcast"));
    }

    @Test
    public void channelHasCorrectLastBuildDate() {
        assertThat(channel.getLastBuildDate(), equalTo(PodcastDate.parsePodcastDate("Tue, 15 Mar 2016 15:21:06 +0000")));
    }

    @Test
    public void channelImageHasCorrectUrl() {
        assertThat(channel.getChannelImage().getUrl(), equalTo("http://minkorrekt.de/wp-content/cache/podlove/67/2193777f638039d26446e56cb3e279/methodisch-inkorrekt_original.jpg"));
    }

    @Test
    public void channelImageHasCorrectTitle() {
        assertThat(channel.getChannelImage().getTitle(), equalTo("Methodisch inkorrekt"));
    }

    @Test
    public void channelImageHasCorrectLink() {
        assertThat(channel.getChannelImage().getLink(), equalTo("http://minkorrekt.de"));
    }

    @Test
    public void channelHasCorrectItem() {
        Item item = channel.getItems().get(0);
        assertThat(item.getLink(), equalTo("http://minkorrekt.de/minkorrekt-folge-69-beule-in-der-strumpfhose/"));
        assertThat(item.getPubDate(), equalTo(PodcastDate.parsePodcastDate("Tue, 08 Mar 2016 08:00:19 +0000")));
        assertThat(item.getTitle(), equalTo("Minkorrekt Folge 69 „Beule in der Strumpfhose“"));
        assertThat(item.getDescription(), equalTo("Folge vom 08.03.2016\nHeute mit Gravitationswellen, Ausreden, einem Stickstofflaser, dem India Gadget der Woche, Motivation und Seifenblasen."));
    }

    @Test
    public void itemHasCorrectEnclosure() throws Exception {
        Item item = channel.getItems().get(0);
        assertThat(item.getEnclosure().getUrl(), equalTo("http://minkorrekt.de/podlove/file/692/s/feed/c/m4a/methodisch_inkorrekt_Folge_69.m4a"));
        assertThat(item.getEnclosure().getLength(), equalTo("168114630"));
        assertThat(item.getEnclosure().getType(), equalTo("audio/mp4"));
    }

}

