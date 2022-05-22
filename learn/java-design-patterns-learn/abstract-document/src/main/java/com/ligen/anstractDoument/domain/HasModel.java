package com.ligen.anstractDoument.domain;

import com.ligen.anstractDoument.Document;
import com.ligen.anstractDoument.domain.enums.Property;

import java.util.Optional;

public interface HasModel extends Document {
    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(Property.MODEL.toString()));
    }
}
