package com.teragrep.bor_01.aip.ci;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public final class DataObjectImpl implements DataObject{
    private final String path;
    private final String container;
    private final String storageURI;
    private static final String namespace = DataObjectImpl.class.getName();
    public DataObjectImpl(final String path, final String container, final String storageURI) {
        this.path = path;
        this.container = container;
        this.storageURI = storageURI;
    }

    @Override
    public String path() {
        return path;
    }

    @Override
    public String container() {
        return container;
    }

    @Override
    public String storageURI() {
        return storageURI;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("path", path)
                .add("container", container)
                .add("storageURI", storageURI)
                .build();
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
