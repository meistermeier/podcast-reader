package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.UtilClassTestingUtils;
import org.junit.Test;

public class NodeProcessorsUtilClassTest {

    @Test
    public void isAnUtilClass() throws Exception {
        UtilClassTestingUtils.assertClassIsUtilClass(NodeProcessors.class);
    }

}
