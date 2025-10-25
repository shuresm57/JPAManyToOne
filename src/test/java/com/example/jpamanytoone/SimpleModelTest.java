package com.example.jpamanytoone;

import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.model.Kommune;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
class SimpleModelTest {

    @Test
    void regionShouldHaveBasicFields() {
        // Opret en region
        Region region = new Region();
        region.setKode("1000");
        region.setNavn("Test Region");
        region.setHref("http://test.dk");

        // Check om felterne er sat korrekt
        assertThat(region.getKode()).isEqualTo("1000");
        assertThat(region.getNavn()).isEqualTo("Test Region");
        assertThat(region.getHref()).isEqualTo("http://test.dk");
    }

    @Test
    void kommuneShouldHaveBasicFields() {
        // Opret en kommune
        Kommune kommune = new Kommune();
        kommune.setKode("0101");
        kommune.setNavn("Test Kommune");
        kommune.setHref("http://test.dk");

        // Check om felterne er sat korrekt
        assertThat(kommune.getKode()).isEqualTo("0101");
        assertThat(kommune.getNavn()).isEqualTo("Test Kommune");
        assertThat(kommune.getHref()).isEqualTo("http://test.dk");
    }

    @Test
    void kommuneShouldBelongToRegion() {
        // Opret region og kommune
        Region region = new Region();
        region.setKode("1000");
        region.setNavn("Test Region");

        Kommune kommune = new Kommune();
        kommune.setKode("0101");
        kommune.setNavn("Test Kommune");
        
        // Sæt relationship
        kommune.setRegion(region);

        // Check relationship virker
        assertThat(kommune.getRegion()).isNotNull();
        assertThat(kommune.getRegion().getKode()).isEqualTo("1000");
        assertThat(kommune.getRegion().getNavn()).isEqualTo("Test Region");
    }
}