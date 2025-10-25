package com.example.jpamanytoone;

import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.repository.RegionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class SimpleRepositoryTest {

    @Autowired
    private RegionRepository regionRepository;

    @Test
    void canSaveAndFindRegion() {
        // Gem en region
        Region region = new Region();
        region.setKode("1000");
        region.setNavn("Test Region");
        regionRepository.save(region);

        // Find regionen igen
        Region found = regionRepository.findById("1000").orElse(null);

        // Check den blev fundet
        assertThat(found).isNotNull();
        assertThat(found.getNavn()).isEqualTo("Test Region");
    }

    @Test
    void deleteByIdIfExistsWorks() {
        // Gem en region
        Region region = new Region();
        region.setKode("1000");
        region.setNavn("Test Region");
        regionRepository.save(region);

        // Slet den
        boolean deleted = regionRepository.deleteByIdIfExists("1000");

        // Check den blev slettet
        assertThat(deleted).isTrue();
        assertThat(regionRepository.findById("1000")).isEmpty();
    }

    @Test
    void deleteNonExistentReturnsFalse() {
        // Prøv at slette noget der ikke findes
        boolean deleted = regionRepository.deleteByIdIfExists("9999");
        
        // Skal returnere false
        assertThat(deleted).isFalse();
    }
}