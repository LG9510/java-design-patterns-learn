package com.ligen.anstractDoument.domain;

import com.ligen.anstractDoument.Document;
import com.ligen.anstractDoument.domain.enums.Property;

import java.util.stream.Stream;

public interface HasParts extends Document {
    default Stream<Part> getParts() {
        return children(Property.PARTS.toString(), Part::new);
    }
}
