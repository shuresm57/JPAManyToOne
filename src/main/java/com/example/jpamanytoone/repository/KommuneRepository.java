package com.example.jpamanytoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpamanytoone.model.Kommune;

@Repository
public interface KommuneRepository extends JpaRepository<Kommune, String> {
    
    @Transactional
    default boolean deleteByIdIfExists(String kode){
        if (existsById(kode)) {
            deleteById(kode);
            return true;
        }
        return false;
    }
}
