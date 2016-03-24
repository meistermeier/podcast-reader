package com.meistermeier.podcast.feedreader.domain;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ChannelBuilderTest {

    @Test(expected = FeedParserException.class)
    public void buildFailsIfNoTitleExists() throws Exception {
        new ChannelBuilder()
                .description("description")
                .link("link")
                .build();
    }

    @Test(expected = FeedParserException.class)
    public void buildFailsIfNoDescriptionExists() throws Exception {
        new ChannelBuilder()
                .title("title")
                .link("link")
                .build();
    }

    @Test(expected = FeedParserException.class)
    public void buildFailsIfNoLinkExists() throws Exception {
        new ChannelBuilder()
                .title("title")
                .description("description")
                .build();
    }

    @Test
    public void buildSuccessesWithRequiredData() throws Exception {
        assertThat(new ChannelBuilder()
                        .title("title")
                        .description("description")
                        .link("link")
                        .build(),
                notNullValue());
    }

    @Test
    public void buildSuccessesWithAllData() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        ChannelImage channelImage = new ChannelImage("url", "title", "link");
        Item item = new Item("title", "link", now, "description", new Enclosure());

        Channel channel = new ChannelBuilder()
                .title("title")
                .description("description")
                .link("link")
                .date(now)
                .channelImage(channelImage)
                .item(item)
                .build();

        assertThat(channel.getTitle(), equalTo("title"));
        assertThat(channel.getDescription(), equalTo("description"));
        assertThat(channel.getLink(), equalTo("link"));
        assertThat(channel.getLastBuildDate().get(), equalTo(now));
        assertThat(channel.getChannelImage().get(), equalTo(channelImage));
        assertThat(channel.getItems().get(0), equalTo(item));
    }
}
