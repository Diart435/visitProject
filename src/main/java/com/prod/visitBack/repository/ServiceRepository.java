package com.prod.visitBack.repository;

import com.prod.visitBack.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{
    List<Service> findByType(int type);
}
