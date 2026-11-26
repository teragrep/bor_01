package com.teragrep.bor_01.aip.ci;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public final class ContentImpl implements Content {
    private final Representation representation;
    private final DataObject dataObject;
    private static final String namespace = ContentImpl.class.getName();
    public ContentImpl(final Representation representation, final DataObject dataObject) {
        this.representation = representation;
        this.dataObject = dataObject;
    }

    @Override
    public Representation representation() {
        return representation;
    }

    @Override
    public DataObject dataObject() {
        return dataObject;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("representation", representation.asJsonObject())
                .add("dataObject", dataObject.asJsonObject())
                .build();
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
