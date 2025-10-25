package com.example.jpamanytoone.service.region;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Region> getAllRegioner() {
        log.debug("Fetching all regioner");
        return regionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Region> getRegionByKode(String kode) {
        log.debug("Fetching region with kode: {}", kode);
        return regionRepository.findById(kode);
    }

    @Override
    public Region saveRegion(Region region) {
        log.debug("Saving region: {}", region.getKode());
        return regionRepository.save(region);
    }

    @Override
    public boolean deleteRegion(String kode) {
        log.debug("Attempting to delete region with kode: {}", kode);
        boolean deleted = regionRepository.deleteByIdIfExists(kode);
        if (deleted) {
            log.info("Successfully deleted region with kode: {}", kode);
        } else {
            log.warn("Region with kode {} not found for deletion", kode);
        }
        return deleted;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Kommune> getKommunerByRegion(String regionKode) {
        log.debug("Fetching kommuner for region: {}", regionKode);
        return regionRepository.findById(regionKode)
                .map(Region::getKommuner)
                .orElse(Collections.emptySet());
    }
}