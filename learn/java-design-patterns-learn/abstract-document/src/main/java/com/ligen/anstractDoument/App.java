package com.ligen.anstractDoument;

import com.ligen.anstractDoument.domain.Car;
import com.ligen.anstractDoument.domain.enums.Property;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class App {
    public static void main(String[] args) {
        LOGGER.info("Constructing parts and car");

        var wheelProperties = Map.of(
                Property.TYPE.toString(), "wheel",
                Property.MODEL.toString(), "15C",
                Property.PRICE.toString(), 100L);

        var doorProperties = Map.of(
                Property.TYPE.toString(), "door",
                Property.MODEL.toString(), "Lambo",
                Property.PRICE.toString(), 300L);

        var carProperties = Map.of(
                Property.MODEL.toString(), "300SL",
                Property.PRICE.toString(), 10000L,
                Property.PARTS.toString(), List.of(wheelProperties, doorProperties));

        var car = new Car(carProperties);

        LOGGER.info("Here is our car:");
        LOGGER.info("-> model: {}", car.getModel().orElseThrow());
        LOGGER.info("-> price: {}", car.getPrice().orElseThrow());
        LOGGER.info("-> parts: ");

        car.getParts().forEach(part -> LOGGER.info("\t{}/{}/{}", part.getType().orElse(null)
                , part.getModel().orElse(null), part.getPrice().orElse(null)));
    }
}
