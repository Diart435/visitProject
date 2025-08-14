package com.prod.visitBack.Controller;

import com.prod.visitBack.DTO.RequestDTO;
import com.prod.visitBack.model.Request;
import com.prod.visitBack.model.Service;
import com.prod.visitBack.service.ServiceListService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {
        "https://electrictlt.ru",
        "https://www.electrictlt.ru",
        "https://90.156.158.187"
})
@RestController
public class ServiceController {
    private final ServiceListService serviceListService;
    public ServiceController(ServiceListService serviceListService){
        this.serviceListService = serviceListService;
    }
    @GetMapping("/services")
    public ResponseEntity<List<List<Service>>> getAllServices(){
        List<Service> list0 = serviceListService.findByType(0);
        List<Service> list1 = serviceListService.findByType(1);
        List<Service> list2 = serviceListService.findByType(2);
        List<List<Service>> allLists = List.of(list0, list1, list2);
        return ResponseEntity.ok(allLists);
    }
}
