package com.meistermeier.podcast.feedreader.parser;

import java.util.ArrayList;
import java.util.List;

class ParserCollection<B> {

    List<InformationProvider<? super B>> providers = new ArrayList<>();

    void add(InformationProvider<? super B> provider) {
        providers.add(provider);
    }

}
