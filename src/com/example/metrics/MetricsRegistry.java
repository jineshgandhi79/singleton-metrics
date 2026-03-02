package com.example.metrics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum MetricsRegistry {

    INSTANCE;

    private final Map<String, Long> counters = new HashMap<>();

    MetricsRegistry() {
    }

    

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }
}