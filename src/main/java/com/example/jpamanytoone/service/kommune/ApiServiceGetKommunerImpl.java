package com.example.jpamanytoone.service.kommune;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.repository.KommuneRepository;
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
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner {

    private final RestTemplate restTemplate;
    private final KommuneRepository kommuneRepository;

    private final String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";

    private void saveKommuner(List<Kommune> kommuner) {
        kommuner.forEach(kommuneRepository::save);
    }

    @Override
    public List<Kommune> getKommuner(){
        try {
            ResponseEntity<List<Kommune>> kommuneResponse =
                    restTemplate.exchange(kommuneUrl,
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Kommune>>(){
                            });
            List<Kommune> kommuner = kommuneResponse.getBody();
            if (kommuner != null) {
                saveKommuner(kommuner);
                return kommuner;
            }
            return Collections.emptyList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch kommuner from API", e);
        }
    }

}
