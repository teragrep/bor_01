package com.teragrep.bor_01.aip.pdi;

import com.teragrep.bor_01.TimeWindow;
import com.teragrep.bor_01.aip.BloomFilter;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

import java.util.*;

public final class ReferenceImpl implements Reference {
    private final TimeWindow timeWindow;
    private final String configurationItem;
    private final String sourceSystem;
    private final Set<BloomFilter> bloomFilters;
    private final UUID id;
    private static final String namespace = ReferenceImpl.class.getName();
    public ReferenceImpl(final TimeWindow timeWindow, final String configurationItem, final String sourceSystem, final Set<BloomFilter> bloomFilters, final UUID id) {
        this.timeWindow = timeWindow;
        this.configurationItem = configurationItem;
        this.sourceSystem = sourceSystem;
        this.bloomFilters = bloomFilters;
        this.id = id;
    }

    @Override
    public TimeWindow timeWindow() {
        return timeWindow;
    }

    @Override
    public String configurationItem() {
        return configurationItem;
    }

    @Override
    public String sourceSystem() {
        return sourceSystem;
    }

    @Override
    public Set<BloomFilter> bloomFilters() {
        return Set.copyOf(bloomFilters);
    }

    @Override
    public UUID id() {
        return id;
    }

    @Override
    public JsonObject asJsonObject() {
        final JsonArrayBuilder bloomFilterArray = Json.createArrayBuilder();

        final SortedSet<BloomFilter> sortedBloomFilters = new TreeSet<>(bloomFilters);

        for (final BloomFilter filter : sortedBloomFilters) {
            bloomFilterArray.add(filter.asJsonObject());
        }

        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("timeWindow", timeWindow.asJsonObject())
                .add("configurationItem", configurationItem)
                .add("sourceSystem", sourceSystem)
                .add("bloomFilters", bloomFilterArray.build())
                .add("id", id.toString())
                .build();
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
