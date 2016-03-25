package com.meistermeier.podcast.feedreader.domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest {

    private static final LocalDateTime NOW = LocalDateTime.now();
    private static final Enclosure enclosure = new Enclosure("url", "length", "type");

    @Test
    public void toStringGeneratesTheRightRepresentation() throws Exception {
        Item item = new Item("title", "link", NOW, "description", enclosure);

        String expectedMessage = "Item{"
                + "title='title', "
                + "link='link', "
                + "pubDate=" + NOW.toString() + ", "
                + "description='description'}";

        assertThat(item.toString(), equalTo(expectedMessage));
    }

    @Test
    public void itemEqualsSelf() throws Exception {
        Item item = new Item("title", "link", NOW, "description", enclosure);
        assertThat(item.equals(item), is(true));
    }

    @Test
    public void itemEqualItemWithTheSameAttributes() throws Exception {
        Item item1 = new Item("title", "link", NOW, "description", enclosure);
        Item item2 = new Item("title", "link", NOW, "description", enclosure);
        assertThat(item1.equals(item2), is(true));
        assertThat(item2.equals(item1), is(true));
    }

    @Test
    public void itemNotEqualItemWithOtherTitle() throws Exception {
        Item item1 = new Item("title", "link", NOW, "description", enclosure);
        Item item2 = new Item("title2", "link", NOW, "description", enclosure);
        assertThat(item1.equals(item2), is(false));
        assertThat(item2.equals(item1), is(false));
    }

    @Test
    public void itemNotEqualItemWithOtherLink() throws Exception {
        Item item1 = new Item("title", "link", NOW, "description", enclosure);
        Item item2 = new Item("title", "link2", NOW, "description", enclosure);
        assertThat(item1.equals(item2), is(false));
        assertThat(item2.equals(item1), is(false));
    }

    @Test
    public void itemNotEqualItemWithOtherDescription() throws Exception {
        Item item1 = new Item("title", "link", NOW, "description", enclosure);
        Item item2 = new Item("title", "link", NOW, "description2", enclosure);
        assertThat(item1.equals(item2), is(false));
        assertThat(item2.equals(item1), is(false));
    }
    @Test
    public void itemNotEqualItemWithOtherPubDate() throws Exception {
        Item item1 = new Item("title", "link", NOW, "description", enclosure);
        Item item2 = new Item("title", "link", LocalDateTime.MAX, "description2", enclosure);
        assertThat(item1.equals(item2), is(false));
        assertThat(item2.equals(item1), is(false));
    }

    @Test
    public void itemNotEqualNull() throws Exception {
        Item item = new Item("title", "link", NOW, "description", enclosure);
        assertThat(item.equals(null), is(false));
    }

    @Test
    public void itemNotEqualOtherObject() throws Exception {
        Item item = new Item("title", "link", NOW, "description", enclosure);
        assertThat(item.equals(new String()), is(false));
    }

    @Test
    public void hashCodeIsTheSameForTwoIdenticalItems() throws Exception {
        Item item1 = new Item("title", "link", NOW, "description", enclosure);
        Item item2 = new Item("title", "link", NOW, "description", enclosure);
        assertThat(item1.hashCode() == item2.hashCode(), is(true));
    }

    @Test
    public void hashCodeDiffersForTwoItemsWithDifferentAttributes() throws Exception {
        Item item1 = new Item("title", "link", NOW, "description", enclosure);
        Item item2 = new Item("title1", "link", NOW, "description", enclosure);
        assertThat(item1.hashCode() == item2.hashCode(), is(false));
    }
}