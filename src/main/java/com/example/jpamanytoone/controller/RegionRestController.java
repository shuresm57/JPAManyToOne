package com.example.jpamanytoone.controller;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.service.region.RegionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class RegionRestController {

    private final RegionService regionService;

    @GetMapping("/regioner")
    public ResponseEntity<List<Region>> regioner(){
        log.info("GET request for all regioner");
        List<Region> regioner = regionService.getAllRegioner();
        return ResponseEntity.ok(regioner);
    }

    @GetMapping("/regioner/{kode}")
    public ResponseEntity<Region> getRegion(@PathVariable String kode){
        log.info("GET request for region with kode: {}", kode);
        return regionService.getRegionByKode(kode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/regioner/{kode}")
    public ResponseEntity<String> deleteRegion(@PathVariable String kode) {
        log.info("DELETE request for region with kode: {}", kode);
        boolean deleted = regionService.deleteRegion(kode);
        return deleted ? 
            ResponseEntity.ok("Region deleted successfully") : 
            ResponseEntity.notFound().build();
    }

    @GetMapping("/regioner/{kode}/kommuner")
    public ResponseEntity<Set<Kommune>> getKommunerByRegion(@PathVariable String kode) {
        log.info("GET request for kommuner in region: {}", kode);
        Set<Kommune> kommuner = regionService.getKommunerByRegion(kode);
        return ResponseEntity.ok(kommuner);
    }

    @PostMapping("/regioner")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        log.info("POST request to create region: {}", region.getKode());
        Region savedRegion = regionService.saveRegion(region);
        return ResponseEntity.ok(savedRegion);
    }
}
