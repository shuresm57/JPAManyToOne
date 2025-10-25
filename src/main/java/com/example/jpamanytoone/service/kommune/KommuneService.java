package com.example.jpamanytoone.service.kommune;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface KommuneService {
    List<Kommune> getAllKommuner();
    Optional<Kommune> getKommuneByKode(String kode);
    Kommune saveKommune(Kommune kommune);
    boolean deleteKommune(String kode);
    Map<Region, List<Kommune>> getRegionerOgKommuner();
}