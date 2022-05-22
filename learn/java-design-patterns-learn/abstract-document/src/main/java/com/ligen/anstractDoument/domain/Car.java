package com.ligen.anstractDoument.domain;

import com.ligen.anstractDoument.AbstractDocument;

import java.util.Map;

public class Car extends AbstractDocument implements HasModel,HasPrice,HasParts {

    public Car(Map<String, Object> properties) {
        super(properties);
    }
}
