package com.meistermeier.podcast.feedreader.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ChannelImageTest {

    @Test
    public void toStringGeneratesTheRightRepresentation() throws Exception {
        ChannelImage channelImage = new ChannelImage("url", "title", "link");

        String expectedMessage = "ChannelImage{"
                + "url='url', "
                + "title='title', "
                + "link='link'}";

        assertThat(channelImage.toString(), equalTo(expectedMessage));
    }

    @Test
    public void channelImageEqualsSelf() throws Exception {
        ChannelImage channelImage = new ChannelImage("url", "title", "link");
        assertThat(channelImage.equals(channelImage), is(true));
    }

    @Test
    public void channelImageEqualChannelImageWithTheSameAttributes() throws Exception {
        ChannelImage channelImage1 = new ChannelImage("url", "title", "link");
        ChannelImage channelImage2 = new ChannelImage("url", "title", "link");
        assertThat(channelImage1.equals(channelImage2), is(true));
        assertThat(channelImage2.equals(channelImage1), is(true));
    }

    @Test
    public void channelImageNotEqualChannelImageWithOtherTitle() throws Exception {
        ChannelImage channelImage1 = new ChannelImage("url", "title", "link");
        ChannelImage channelImage2 = new ChannelImage("title2", "link", "description");
        assertThat(channelImage1.equals(channelImage2), is(false));
        assertThat(channelImage2.equals(channelImage1), is(false));
    }

    @Test
    public void channelImageNotEqualChannelImageWithOtherLink() throws Exception {
        ChannelImage channelImage1 = new ChannelImage("url", "title", "link");
        ChannelImage channelImage2 = new ChannelImage("title", "link2", "description");
        assertThat(channelImage1.equals(channelImage2), is(false));
        assertThat(channelImage2.equals(channelImage1), is(false));
    }

    @Test
    public void channelImageNotEqualChannelImageWithOtherDescription() throws Exception {
        ChannelImage channelImage1 = new ChannelImage("url", "title", "link");
        ChannelImage channelImage2 = new ChannelImage("title", "link", "description2");
        assertThat(channelImage1.equals(channelImage2), is(false));
        assertThat(channelImage2.equals(channelImage1), is(false));
    }

    @Test
    public void channelImageNotEqualNull() throws Exception {
        ChannelImage channelImage = new ChannelImage("url", "title", "link");
        assertThat(channelImage.equals(null), is(false));
    }

    @Test
    public void channelImageNotEqualOtherObject() throws Exception {
        ChannelImage channelImage = new ChannelImage("url", "title", "link");
        assertThat(channelImage.equals(new String()), is(false));
    }

    @Test
    public void hashCodeIsTheSameForTwoIdenticalChannelImages() throws Exception {
        ChannelImage channelImage1 = new ChannelImage("url", "title", "link");
        ChannelImage channelImage2 = new ChannelImage("url", "title", "link");
        assertThat(channelImage1.hashCode() == channelImage2.hashCode(), is(true));
    }

    @Test
    public void hashCodeDiffersForTwoChannelImagesWithDifferentAttributes() throws Exception {
        ChannelImage channelImage1 = new ChannelImage("url", "title", "link");
        ChannelImage channelImage2 = new ChannelImage("title1", "link", "description");
        assertThat(channelImage1.hashCode() == channelImage2.hashCode(), is(false));
    }
}