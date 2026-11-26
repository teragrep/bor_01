package com.teragrep.bor_01.aip.pdi;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public final class AccessRightsImpl implements AccessRights {
    private final String index;
    private static final String namespace = AccessRightsImpl.class.getName();
    public AccessRightsImpl(final String index) {
        this.index = index;
    }

    @Override
    public String index() {
        return index;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("index", index)
                .build();
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
