package com.usa.app.g24.rentas.controller;

import com.usa.app.g24.rentas.dto.MessageRequest;
import com.usa.app.g24.rentas.model.Message;
import com.usa.app.g24.rentas.service.MessageService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("Message")
public class MessageController implements Serializable {

    @Autowired
    private MessageService messageService;

    @PostMapping("save")
    public ResponseEntity<?> guardar(@RequestBody MessageRequest request){
        try {
            messageService.guardar(request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("all")
    public List<Message> listaDeMensajes(){
        return messageService.message();
    }
}
