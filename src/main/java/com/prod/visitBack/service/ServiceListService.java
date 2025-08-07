package com.prod.visitBack.service;

import com.prod.visitBack.repository.ServiceRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceListService {
    private final ServiceRepository serviceRepository;
    public ServiceListService(ServiceRepository serviceRepository){
        this.serviceRepository = serviceRepository;
    }

    public List<com.prod.visitBack.model.Service> getServiceList(){
        return serviceRepository.findAll();
    }
    public List<com.prod.visitBack.model.Service> findByType(int type){
        return serviceRepository.findByType(type);
    }

}
