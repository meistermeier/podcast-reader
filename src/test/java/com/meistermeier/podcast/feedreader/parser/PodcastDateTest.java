package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.UtilClassTestingUtils;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PodcastDateTest {

    @Test
    public void parsesGivenDateInCorrectFormat() throws Exception {
        LocalDateTime parse = PodcastDate.parsePodcastDate("Tue, 08 Mar 2016 08:00:19 +0000");
        assertThat(parse, notNullValue());
        assertThat(parse.getDayOfWeek(), equalTo(DayOfWeek.TUESDAY));
        assertThat(parse.getDayOfMonth(), equalTo(8));
        assertThat(parse.getMonth(), equalTo(Month.MARCH));
        assertThat(parse.getYear(), equalTo(2016));
        assertThat(parse.getHour(), equalTo(8));
        assertThat(parse.getMinute(), equalTo(0));
        assertThat(parse.getSecond(), equalTo(19));
    }

    @Test
    public void classIsNotInstantiableAndFinal() throws Exception {
        Class<PodcastDate> classUnderTest = PodcastDate.class;
        UtilClassTestingUtils.assertClassIsUtilClass(classUnderTest);
    }

}
