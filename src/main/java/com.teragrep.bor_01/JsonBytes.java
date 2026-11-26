package com.teragrep.bor_01;

import java.nio.charset.StandardCharsets;

public final class JsonBytes implements Byteable{
    private final NamespacedJsonable origin;

    public JsonBytes(final NamespacedJsonable origin) {
        this.origin = origin;
    }

    @Override
    public byte[] bytes() {
        return origin.asJsonObject().toString().getBytes(StandardCharsets.UTF_8);
    }
}
