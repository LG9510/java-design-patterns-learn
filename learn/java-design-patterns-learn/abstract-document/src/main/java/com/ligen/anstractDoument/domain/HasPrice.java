package com.ligen.anstractDoument.domain;

import com.ligen.anstractDoument.Document;
import com.ligen.anstractDoument.domain.enums.Property;

import java.util.Optional;

public interface HasPrice extends Document {
    default Optional<Number> getPrice() {
        return Optional.ofNullable( (Number)get(Property.PRICE.toString()));
    }
}
