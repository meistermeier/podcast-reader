package com.meistermeier.podcast.feedreader.domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EnclosureTest {
    private static final LocalDateTime NOW = LocalDateTime.now();

    @Test
    public void toStringGeneratesTheRightRepresentation() throws Exception {
        Enclosure enclosure = new Enclosure("url", "length", "type");

        String expectedMessage = "Enclosure{"
                + "url='url', "
                + "length='length', "
                + "type='type'}";

        assertThat(enclosure.toString(), equalTo(expectedMessage));
    }

    @Test
    public void enclosureEqualsSelf() throws Exception {
        Enclosure enclosure = new Enclosure("url", "length", "type");
        assertThat(enclosure.equals(enclosure), is(true));
    }

    @Test
    public void enclosureEqualEnclosureWithTheSameAttributes() throws Exception {
        Enclosure enclosure1 = new Enclosure("url", "length", "type");
        Enclosure enclosure2 = new Enclosure("url", "length", "type");
        assertThat(enclosure1.equals(enclosure2), is(true));
        assertThat(enclosure2.equals(enclosure1), is(true));
    }

    @Test
    public void enclosureNotEqualEnclosureWithOtherUrl() throws Exception {
        Enclosure enclosure1 = new Enclosure("url", "length", "type");
        Enclosure enclosure2 = new Enclosure("url2", "length", "type");
        assertThat(enclosure1.equals(enclosure2), is(false));
        assertThat(enclosure2.equals(enclosure1), is(false));
    }

    @Test
    public void enclosureNotEqualEnclosureWithOtherLength() throws Exception {
        Enclosure enclosure1 = new Enclosure("url", "length", "type");
        Enclosure enclosure2 = new Enclosure("url", "length2", "type");
        assertThat(enclosure1.equals(enclosure2), is(false));
        assertThat(enclosure2.equals(enclosure1), is(false));
    }

    @Test
    public void enclosureNotEqualEnclosureWithOtherType() throws Exception {
        Enclosure enclosure1 = new Enclosure("url", "length", "type");
        Enclosure enclosure2 = new Enclosure("url", "length", "type2");
        assertThat(enclosure1.equals(enclosure2), is(false));
        assertThat(enclosure2.equals(enclosure1), is(false));
    }

    @Test
    public void enclosureNotEqualNull() throws Exception {
        Enclosure enclosure = new Enclosure("url", "length", "type");
        assertThat(enclosure.equals(null), is(false));
    }

    @Test
    public void enclosureNotEqualOtherObject() throws Exception {
        Enclosure enclosure = new Enclosure("url", "length", "type");
        assertThat(enclosure.equals(new String()), is(false));
    }

    @Test
    public void hashCodeIsTheSameForTwoIdenticalEnclosures() throws Exception {
        Enclosure enclosure1 = new Enclosure("url", "length", "type");
        Enclosure enclosure2 = new Enclosure("url", "length", "type");
        assertThat(enclosure1.hashCode() == enclosure2.hashCode(), is(true));
    }

    @Test
    public void hashCodeDiffersForTwoEnclosuresWithDifferentAttributes() throws Exception {
        Enclosure enclosure1 = new Enclosure("url", "length", "type");
        Enclosure enclosure2 = new Enclosure("url2", "length", "type");
        assertThat(enclosure1.hashCode() == enclosure2.hashCode(), is(false));
    }
}