package com.prod.visitBack.service;

import com.prod.visitBack.DTO.RequestDTO;
import com.prod.visitBack.model.Request;
import com.prod.visitBack.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    private final RequestRepository requestRepository;
    public RequestService(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }
    public void addRequest(RequestDTO requestDTO){
        Request request = new Request(requestDTO.getUserName(), requestDTO.getPhoneNumber());
        requestRepository.save(request);
    }
    public int getAmount()
    {
        return requestRepository.findAll().size();
    }
    public List<Request> findAll(){
        return requestRepository.findAll();
    }
    public void deleteAll()
    {
        requestRepository.deleteAll();
    }
}
