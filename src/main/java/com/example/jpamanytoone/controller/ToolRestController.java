package com.example.jpamanytoone.controller;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.service.kommune.ApiServiceGetKommuner;
import com.example.jpamanytoone.service.region.ApiServiceGetRegioner;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tool")
@RequiredArgsConstructor
public class ToolRestController {

    private final ApiServiceGetRegioner apiServiceGetRegioner;
    private final ApiServiceGetKommuner apiServiceGetKommuner;

    @GetMapping("/getregioner")
    public List<Region> getRegioner() {
        return apiServiceGetRegioner.getRegioner();
    }

    @GetMapping("/getkommuner")
    public List<Kommune> getKommuner() {
        return apiServiceGetKommuner.getKommuner();
    }
}
