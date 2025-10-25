package com.example.jpamanytoone.service.region;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RegionService {
    List<Region> getAllRegioner();
    Optional<Region> getRegionByKode(String kode);
    Region saveRegion(Region region);
    boolean deleteRegion(String kode);
    Set<Kommune> getKommunerByRegion(String regionKode);
}