package com.example.jpamanytoone.service.kommune;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.repository.KommuneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class KommuneServiceImpl implements KommuneService {

    private final KommuneRepository kommuneRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Kommune> getAllKommuner() {
        log.debug("Fetching all kommuner");
        return kommuneRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Kommune> getKommuneByKode(String kode) {
        log.debug("Fetching kommune with kode: {}", kode);
        return kommuneRepository.findById(kode);
    }

    @Override
    public Kommune saveKommune(Kommune kommune) {
        log.debug("Saving kommune: {}", kommune.getKode());
        return kommuneRepository.save(kommune);
    }

    @Override
    public boolean deleteKommune(String kode) {
        log.debug("Attempting to delete kommune with kode: {}", kode);
        boolean deleted = kommuneRepository.deleteByIdIfExists(kode);
        if (deleted) {
            log.info("Successfully deleted kommune with kode: {}", kode);
        } else {
            log.warn("Kommune with kode {} not found for deletion", kode);
        }
        return deleted;
    }

    @Override
    @Transactional(readOnly = true)
    public Map<Region, List<Kommune>> getRegionerOgKommuner() {
        log.debug("Fetching regioner og kommuner mapping");
        return kommuneRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Kommune::getRegion));
    }
}