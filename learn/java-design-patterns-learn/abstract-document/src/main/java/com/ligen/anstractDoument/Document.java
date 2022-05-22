package com.ligen.anstractDoument;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Document {
    /**
     * Puts the value related to the key
     *
     * @param key   element key
     * @param value element value
     * @return
     */
    Void put(String key, Object value);

    /**
     * gets the value for the key.
     *
     * @param key element value
     * @return value or null
     */
    Object get(String key);

    /**
     * Gets the stream of child documents.
     *
     * @param key element key
     * @param constructor constructor of child class
     * @param <T> child document
     * @return
     */
    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
