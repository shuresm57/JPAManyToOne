package com.example.jpamanytoone.controller;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.service.kommune.KommuneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class KommuneRestController {

    private final KommuneService kommuneService;

    @GetMapping("/kommuner")
    public ResponseEntity<List<Kommune>> kommuner() {
        log.info("GET request for all kommuner");
        List<Kommune> kommuner = kommuneService.getAllKommuner();
        return ResponseEntity.ok(kommuner);
    }

    @GetMapping("/kommune/{kode}")
    public ResponseEntity<Kommune> getKommune(@PathVariable String kode) {
        log.info("GET request for kommune with kode: {}", kode);
        return kommuneService.getKommuneByKode(kode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/regioner-og-kommuner")
    public ResponseEntity<Map<Region, List<Kommune>>> regionerOgKommuner() {
        log.info("GET request for regioner og kommuner mapping");
        Map<Region, List<Kommune>> mapping = kommuneService.getRegionerOgKommuner();
        return ResponseEntity.ok(mapping);
    }

    @DeleteMapping("/kommuner/{kode}")
    public ResponseEntity<String> deleteKommune(@PathVariable String kode) {
        log.info("DELETE request for kommune with kode: {}", kode);
        boolean deleted = kommuneService.deleteKommune(kode);
        return deleted ? 
            ResponseEntity.ok("Kommune deleted successfully") : 
            ResponseEntity.notFound().build();
    }

    @PostMapping("/kommuner")
    public ResponseEntity<Kommune> createKommune(@RequestBody Kommune kommune) {
        log.info("POST request to create kommune: {}", kommune.getKode());
        Kommune savedKommune = kommuneService.saveKommune(kommune);
        return ResponseEntity.ok(savedKommune);
    }
}