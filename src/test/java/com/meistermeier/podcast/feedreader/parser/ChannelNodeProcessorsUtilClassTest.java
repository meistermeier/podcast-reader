package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.UtilClassTestingUtils;
import org.junit.Test;

public class ChannelNodeProcessorsUtilClassTest {

    @Test
    public void isAnUtilClass() throws Exception {
        UtilClassTestingUtils.assertClassIsUtilClass(ChannelNodeProcessors.class);
    }

}
