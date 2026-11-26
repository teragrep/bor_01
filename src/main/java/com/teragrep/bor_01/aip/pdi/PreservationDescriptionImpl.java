package com.teragrep.bor_01.aip.pdi;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public final class PreservationDescriptionImpl implements PreservationDescription{
    private final Reference reference;
    private final Provenance provenance;
    private final Context context;
    private final Fixity fixity;
    private final AccessRights accessRights;
    private static final String namespace = PreservationDescriptionImpl.class.getName();
    public PreservationDescriptionImpl(final Reference reference, final Provenance provenance, final Context context, final Fixity fixity, final AccessRights accessRights) {
        this.reference = reference;
        this.provenance = provenance;
        this.context = context;
        this.fixity = fixity;
        this.accessRights = accessRights;
    }

    @Override
    public Reference reference() {
        return reference;
    }

    @Override
    public Provenance provenance() {
        return provenance;
    }

    @Override
    public Context context() {
        return context;
    }

    @Override
    public Fixity fixity() {
        return fixity;
    }

    @Override
    public AccessRights accessRights() {
        return accessRights;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("reference", reference.asJsonObject())
                .add("provenance", provenance.asJsonObject())
                .add("context", context.asJsonObject())
                .add("fixity", fixity.asJsonObject())
                .add("accessRights", accessRights.asJsonObject())
                .build();
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
