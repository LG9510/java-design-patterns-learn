package com.ligen.anstractDoument.domain;

import com.ligen.anstractDoument.AbstractDocument;

import java.util.Map;
import java.util.Optional;

public class Part extends AbstractDocument implements HasModel, HasType, HasPrice {
    public Part(Map<String, Object> properties) {
        super(properties);
    }
}
