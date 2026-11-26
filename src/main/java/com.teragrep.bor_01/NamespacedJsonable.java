package com.teragrep.bor_01;

import jakarta.json.JsonObject;

public interface NamespacedJsonable extends Namespaceable {
    JsonObject asJsonObject();
}
