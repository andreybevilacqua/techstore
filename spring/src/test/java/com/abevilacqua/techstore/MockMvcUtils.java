package com.abevilacqua.techstore;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public final class MockMvcUtils {

    public static MockMvc createMockMvc(Object controller) {
        return standaloneSetup(controller).build();
    }
}
