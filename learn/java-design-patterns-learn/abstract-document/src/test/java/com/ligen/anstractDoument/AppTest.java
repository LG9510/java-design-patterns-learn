package com.ligen.anstractDoument;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void shouldExecuteAppWithoutException() {
        assertDoesNotThrow(() -> App.main(null));
    }
}