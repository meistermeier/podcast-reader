package com.meistermeier.podcast.feedreader.domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ChannelTest {

    @Test
    public void toStringGeneratesTheRightRepresentation() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        Channel channel = new Channel("title", "link", "description", now, null, null);

        String expectedMessage = "Channel{"
                + "title='title', "
                + "link='link', "
                + "description='description', "
                + "lastBuildDate=" + now.toString()
                + "}";

        assertThat(channel.toString(), equalTo(expectedMessage));
    }

    @Test
    public void channelEqualsSelf() throws Exception {
        Channel channel = new Channel("title", "link", "description", null, null, null);
        assertThat(channel.equals(channel), is(true));
    }

    @Test
    public void channelEqualChannelWithTheSameAttributes() throws Exception {
        Channel channel1 = new Channel("title", "link", "description", null, null, null);
        Channel channel2 = new Channel("title", "link", "description", null, null, null);
        assertThat(channel1.equals(channel2), is(true));
        assertThat(channel2.equals(channel1), is(true));
    }

    @Test
    public void channelNotEqualChannelWithOtherTitle() throws Exception {
        Channel channel1 = new Channel("title", "link", "description", null, null, null);
        Channel channel2 = new Channel("title2", "link", "description", null, null, null);
        assertThat(channel1.equals(channel2), is(false));
        assertThat(channel2.equals(channel1), is(false));
    }

    @Test
    public void channelNotEqualChannelWithOtherLink() throws Exception {
        Channel channel1 = new Channel("title", "link", "description", null, null, null);
        Channel channel2 = new Channel("title", "link2", "description", null, null, null);
        assertThat(channel1.equals(channel2), is(false));
        assertThat(channel2.equals(channel1), is(false));
    }

    @Test
    public void channelNotEqualChannelWithOtherDescription() throws Exception {
        Channel channel1 = new Channel("title", "link", "description", null, null, null);
        Channel channel2 = new Channel("title", "link", "description2", null, null, null);
        assertThat(channel1.equals(channel2), is(false));
        assertThat(channel2.equals(channel1), is(false));
    }

    @Test
    public void channelNotEqualNull() throws Exception {
        Channel channel = new Channel("title", "link", "description", null, null, null);
        assertThat(channel.equals(null), is(false));
    }

    @Test
    public void channelNotEqualOtherObject() throws Exception {
        Channel channel = new Channel("title", "link", "description", null, null, null);
        assertThat(channel.equals(new String()), is(false));
    }

    @Test
    public void hashCodeIsTheSameForTwoIdenticalChannels() throws Exception {
        Channel channel1 = new Channel("title", "link", "description", null, null, null);
        Channel channel2 = new Channel("title", "link", "description", null, null, null);
        assertThat(channel1.hashCode() == channel2.hashCode(), is(true));
    }

    @Test
    public void hashCodeDiffersForTwoChannelsWithDifferentAttributes() throws Exception {
        Channel channel1 = new Channel("title", "link", "description", null, null, null);
        Channel channel2 = new Channel("title1", "link", "description", null, null, null);
        assertThat(channel1.hashCode() == channel2.hashCode(), is(false));
    }
}
