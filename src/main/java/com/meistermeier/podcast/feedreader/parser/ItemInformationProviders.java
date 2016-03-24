package com.meistermeier.podcast.feedreader.parser;

import com.meistermeier.podcast.feedreader.domain.Enclosure;
import com.meistermeier.podcast.feedreader.domain.EnclosureProvider;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.meistermeier.podcast.feedreader.parser.InformationProviders.dateProvider;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.descriptionProvider;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.linkProvider;
import static com.meistermeier.podcast.feedreader.parser.InformationProviders.titleProvider;

final class ItemInformationProviders {

    private ItemInformationProviders() {

    }

    static InformationProvider<EnclosureProvider> enclosureProvider = (node, builder) -> {
        if ("enclosure".equals(node.getNodeName())) {
            Enclosure enclosure = new Enclosure();
            enclosure.setUrl(node.getAttributes().getNamedItem("url").getTextContent());
            enclosure.setLength(node.getAttributes().getNamedItem("length").getTextContent());
            enclosure.setType(node.getAttributes().getNamedItem("type").getTextContent());
            builder.enclosure(enclosure);
        }
    };

    static Set<InformationProvider> ITEM_INFORMATION_PROVIDERS = Collections.unmodifiableSet(
            Stream.of(titleProvider,
                    descriptionProvider,
                    dateProvider,
                    linkProvider,
                    enclosureProvider)
                    .collect(Collectors.toSet()));
}
