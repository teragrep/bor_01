package com.teragrep.bor_01.aip.pdi;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.time.Instant;

public final class ProvenanceImpl implements Provenance {
    private final Instant epochArchived;
    private final String processingId;
    private static final String namespace = ProvenanceImpl.class.getName();
    public ProvenanceImpl(final Instant epochArchived, final String processingId) {
        this.epochArchived = epochArchived;
        this.processingId = processingId;
    }

    @Override
    public Instant epochArchived() {
        return epochArchived;
    }

    @Override
    public String processingId() {
        return processingId;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("epochArchived", epochArchived.getEpochSecond())
                .add("processingId", processingId)
                .build();
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
