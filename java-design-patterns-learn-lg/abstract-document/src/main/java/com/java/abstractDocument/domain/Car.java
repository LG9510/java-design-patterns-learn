package com.java.abstractDocument.domain;

import com.java.abstractDocument.AbstractDocument;

import java.util.Map;

public class Car extends AbstractDocument implements HasModel,HasParts,HasPrice {
    public Car(Map<String, Object> properties) {
        super(properties);
    }
}
