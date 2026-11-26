package com.teragrep.bor_01.aip.ci;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public final class RepresentationImpl implements Representation{
    private final String sourceType;
    private final String objectFormat;
    private static final String namespace = RepresentationImpl.class.getName();
    public RepresentationImpl(final String sourceType, final String objectFormat) {
        this.sourceType = sourceType;
        this.objectFormat = objectFormat;
    }

    @Override
    public String sourceType() {
        return sourceType;
    }

    @Override
    public String objectFormat() {
        return objectFormat;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("sourceType", sourceType)
                .add("objectFormat", objectFormat)
                .build();
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
