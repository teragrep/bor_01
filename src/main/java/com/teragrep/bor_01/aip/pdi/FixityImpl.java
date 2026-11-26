package com.teragrep.bor_01.aip.pdi;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.time.Instant;
import java.util.Base64;

public final class FixityImpl implements Fixity{
    private final byte[] sha256Hash;
    private final Instant epochExpires;
    private static final String namespace = FixityImpl.class.getName();
    public FixityImpl(final byte[] sha256Hash, final Instant epochExpires) {
        this.sha256Hash = sha256Hash;
        this.epochExpires = epochExpires;
    }

    @Override
    public byte[] sha256Hash() {
        return sha256Hash;
    }

    @Override
    public Instant epochExpires() {
        return epochExpires;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("sha256Hash", Base64.getEncoder().encodeToString(sha256Hash))
                .add("epochExpires", epochExpires.getEpochSecond())
                .build();
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
