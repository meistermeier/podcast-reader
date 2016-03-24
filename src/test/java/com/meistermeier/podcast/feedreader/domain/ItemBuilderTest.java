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

    @Test(expected = FeedParserException.class)
    public void buildFailsIfEnclosureHasMissingUrl() throws Exception {
        new ItemBuilder().title("title").enclosure(null, "length", "type").build();
    }

    @Test(expected = FeedParserException.class)
    public void buildFailsIfEnclosureHasMissingLength() throws Exception {
        new ItemBuilder().title("title").enclosure("url", null, "type").build();
    }

    @Test(expected = FeedParserException.class)
    public void buildFailsIfEnclosureHasMissingType() throws Exception {
        new ItemBuilder().title("title").enclosure("url", "length", null).build();
    }

    @Test(expected = FeedParserException.class)
    public void buildFailsIfEnclosureHasAllAttributesMissing() throws Exception {
        new ItemBuilder().title("title").enclosure(null, null, null).build();
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
        Enclosure enclosure = new Enclosure("url", "length", "type");

        Item item = new ItemBuilder()
                .title("title")
                .description("description")
                .link("link")
                .date(now)
                .enclosure("url", "length", "type")
                .build();

        assertThat(item.getTitle().get(), equalTo("title"));
        assertThat(item.getDescription().get(), equalTo("description"));
        assertThat(item.getLink().get(), equalTo("link"));
        assertThat(item.getPubDate().get(), equalTo(now));
        assertThat(item.getEnclosure().get(), equalTo(enclosure));
    }
}
