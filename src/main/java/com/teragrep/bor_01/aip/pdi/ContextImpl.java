package com.teragrep.bor_01.aip.pdi;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public final class ContextImpl implements Context {
    private final String logtag;
    private final String hostname;
    private final String organization;
    private static final String namespace = ContextImpl.class.getName();
    public ContextImpl(final String logtag, final String hostname, final String organization) {
        this.logtag = logtag;
        this.hostname = hostname;
        this.organization = organization;
    }

    @Override
    public String logtag() {
        return logtag;
    }

    @Override
    public String hostname() {
        return hostname;
    }

    @Override
    public String organization() {
        return organization;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("logtag", logtag)
                .add("hostname", hostname)
                .add("organization", organization)
                .build();
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
