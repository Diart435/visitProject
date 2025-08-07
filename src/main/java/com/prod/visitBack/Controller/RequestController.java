package com.prod.visitBack.Controller;

import com.prod.visitBack.DTO.RequestDTO;
import com.prod.visitBack.model.Request;
import com.prod.visitBack.service.RequestService;
import com.prod.visitBack.service.TelegramService;
import jakarta.validation.Valid;
import jdk.jfr.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200/", "http://192.168.1.71:4200"})
@RestController
public class RequestController {
    private final RequestService requestService;
    private final TelegramService telegramService;
    public RequestController(RequestService requestService, TelegramService telegramService){
        this.requestService = requestService;
        this.telegramService = telegramService;
    }
    @PostMapping("/request")
    public ResponseEntity<Request> addRequest(@Valid @RequestBody RequestDTO requestDTO)
    {
        requestService.addRequest(requestDTO);
        telegramService.sendMessage(5743914463L,"Вы получили новую заявку: " + requestDTO.getUserName() + " " + requestDTO.getPhoneNumber());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
