package com.ligen.anstractDoument;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractDocumentTest {
    private static final String KEY = "key";

    public static final String VALUE = "value";

    private static class DocumentImplementation extends AbstractDocument {
        protected DocumentImplementation(Map<String, Object> properties) {
            super(properties);
        }
    }

    private final DocumentImplementation document = new DocumentImplementation(new HashMap<>());

    @Test
    void shouldPutAndGetValue() {
        document.put(KEY, VALUE);
        assertEquals(VALUE, document.get(KEY));
    }

    @Test
    void shouldRetrieveChildren() {
        var children = List.of(Map.of(), Map.of());
        document.put(KEY, children);

        var childrenStream = document.children(KEY, DocumentImplementation::new);
        assertNotNull(children);
        assertEquals(2, childrenStream.count());
    }

    @Test
    void shouldRetrieveEmptyStreamForNonExistingChildren() {
        var children = document.children(KEY, DocumentImplementation::new);
        assertNotNull(children);
        assertEquals(0, children.count());
    }
}
