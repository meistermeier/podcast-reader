package com.meistermeier.podcast.feedreader.domain;

import com.meistermeier.podcast.feedreader.common.FeedParserException;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ItemBuilderTest {

    @Test(expected = FeedParserException.class)
    public void buildFailsIfNeitherTitleOrDescriptionExists() throws Exception {
        new ItemBuilder().build();
    }

    @Test
    public void buildSuccessesIfTitleExists() throws Exception {
        assertThat(new ItemBuilder().title("title").build(), notNullValue());
    }

    @Test
    public void buildSuccessesIfDescriptionExists() throws Exception {
        assertThat(new ItemBuilder().description("description").build(), notNullValue());
    }

    @Test
    public void buildSuccessesWithAllData() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        Enclosure enclosure = new Enclosure();

        Item item = new ItemBuilder()
                .title("title")
                .description("description")
                .link("link")
                .date(now)
                .enclosure(enclosure)
                .build();

        assertThat(item.getTitle(), equalTo("title"));
        assertThat(item.getDescription(), equalTo("description"));
        assertThat(item.getLink(), equalTo("link"));
        assertThat(item.getPubDate(), equalTo(now));
        assertThat(item.getEnclosure(), notNullValue());
    }
}
