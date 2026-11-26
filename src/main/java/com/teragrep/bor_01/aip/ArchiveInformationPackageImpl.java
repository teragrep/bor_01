package com.teragrep.bor_01.aip;

import com.teragrep.bor_01.aip.ci.Content;
import com.teragrep.bor_01.aip.pdi.PreservationDescription;
import jakarta.json.Json;
import jakarta.json.JsonObject;

public final class ArchiveInformationPackageImpl implements ArchiveInformationPackage {
    private final Content content;
    private final PreservationDescription preservationDescription;
    private static final String namespace = ArchiveInformationPackageImpl.class.getName();

    public ArchiveInformationPackageImpl(final Content content, final PreservationDescription preservationDescription) {
        this.content = content;
        this.preservationDescription = preservationDescription;
    }

    @Override
    public Content content() {
        return content;
    }

    @Override
    public PreservationDescription preservationDescription() {
        return preservationDescription;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("content", content.asJsonObject())
                .add("preservationDescription", preservationDescription.asJsonObject())
                .build();
    }

    public String namespace() {
        return namespace;
    }
}
