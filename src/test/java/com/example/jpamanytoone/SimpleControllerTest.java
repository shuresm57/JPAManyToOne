package com.example.jpamanytoone;

import com.example.jpamanytoone.controller.RegionRestController;
import com.example.jpamanytoone.controller.KommuneRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class SimpleControllerTest {

    @Autowired
    private RegionRestController regionController;

    @Autowired
    private KommuneRestController kommuneController;

    @Test
    void regionControllerShouldBeCreated() {
        // Tjek om controller kan oprettes
        assertThat(regionController).isNotNull();
    }

    @Test
    void kommuneControllerShouldBeCreated() {
        // Tjek om controller kan oprettes
        assertThat(kommuneController).isNotNull();
    }

    @Test
    void regionControllerShouldReturnEmptyList() {
        // Test basic funktionalitet (tom database)
        var result = regionController.regioner();
        assertThat(result).isNotNull();
        assertThat(result).isEmpty(); // Tom database i test
    }

    @Test
    void kommuneControllerShouldReturnEmptyList() {
        // Test basic funktionalitet (tom database)
        var result = kommuneController.kommuner();
        assertThat(result).isNotNull();
        assertThat(result).isEmpty(); // Tom database i test
    }
}