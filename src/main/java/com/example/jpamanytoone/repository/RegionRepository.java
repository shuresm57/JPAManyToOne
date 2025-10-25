package com.example.jpamanytoone.repository;

import com.example.jpamanytoone.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RegionRepository extends JpaRepository<Region, String> {
    
    @Transactional
    default boolean deleteByIdIfExists(String kode){
        if (existsById(kode)) {
            deleteById(kode);
            return true;
        }
        return false;
    }
}
