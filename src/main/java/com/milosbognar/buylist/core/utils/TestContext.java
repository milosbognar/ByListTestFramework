package com.milosbognar.buylist.core.utils;

import java.util.concurrent.ConcurrentHashMap;

public class TestContext {

    private static TestContext testContext = new TestContext();
    private final ConcurrentHashMap<String, Object> context = new ConcurrentHashMap<>();

    private TestContext() {
    }

    public static ConcurrentHashMap<String, Object> getContext() {
        return testContext.context;
    }

    public void put(String key, Object value) {
        context.put(key, value);
    }

    public Object getOrDefault(String key, Object defaultValue) {
        return context.getOrDefault(key, defaultValue);
    }

    public boolean containsKey(String key) {
        return context.containsKey(key);
    }

    public void cleanContext() {
        context.clear();
    }

    public void removeKey(String key) {
        context.remove(key);
    }
}
