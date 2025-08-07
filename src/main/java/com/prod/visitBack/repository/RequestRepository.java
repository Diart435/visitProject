package com.prod.visitBack.repository;

import com.prod.visitBack.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {
}
