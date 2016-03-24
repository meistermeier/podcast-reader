package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.UtilClassTestingUtils;
import org.junit.Test;

public class InformationProvidersUtilClassTest {

    @Test
    public void isAnUtilClass() throws Exception {
        UtilClassTestingUtils.assertClassIsUtilClass(InformationProviders.class);
    }

}
