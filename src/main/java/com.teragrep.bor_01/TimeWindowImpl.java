package com.teragrep.bor_01;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.time.Duration;
import java.time.Instant;

public class TimeWindowImpl implements TimeWindow {
    private final Instant startTime;
    private final Duration duration;
    private static final String namespace = TimeWindowImpl.class.getName();
    public TimeWindowImpl(final Instant startTime, final Duration duration) {
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public Instant startTime() {
        return startTime;
    }

    @Override
    public Duration duration() {
        return duration;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("startTime", startTime.getEpochSecond())
                .add("duration", duration.toString())
                .build();
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
