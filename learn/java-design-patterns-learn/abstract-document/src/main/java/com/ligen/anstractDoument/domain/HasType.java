package com.ligen.anstractDoument.domain;

import com.ligen.anstractDoument.Document;
import com.ligen.anstractDoument.domain.enums.Property;

import java.util.Optional;

public interface HasType extends Document {
    default Optional<String> getType() {
        return Optional.ofNullable((String) get(Property.TYPE.toString()));
    }
}
