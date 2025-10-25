package com.example.jpamanytoone.service.region;

import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiServiceGetRegionerImpl implements ApiServiceGetRegioner {

    private final RestTemplate restTemplate;
    private final RegionRepository regionRepository;

    private final String regionUrl = "https://api.dataforsyningen.dk/regioner";

    private void saveRegioner(List<Region> regioner) {
        regioner.forEach(regionRepository::save);
    }

    @Override
    public List<Region> getRegioner(){
        try {
            ResponseEntity<List<Region>> regionResponse =
                    restTemplate.exchange(regionUrl,
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Region>>(){
                            });
            List<Region> regioner = regionResponse.getBody();
            if (regioner != null) {
                saveRegioner(regioner);
                return regioner;
            }
            return Collections.emptyList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch regions from API", e);
        }
    }

}
