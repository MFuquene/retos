package com.usa.app.g24.rentas.service;

import com.usa.app.g24.rentas.dto.MessageRequest;
import com.usa.app.g24.rentas.model.Car;
import com.usa.app.g24.rentas.model.Client;
import com.usa.app.g24.rentas.model.Message;
import com.usa.app.g24.rentas.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private ClientService clientService;

    public void guardar(MessageRequest request) throws Exception{
        Car car = carService.carPorId(request.getCar().getIdCar());
        Client client = clientService.clientPorId(request.getClient().getIdClient());

        if (car==null){
            throw new Exception("Hace falta el carro");
        }

        Message message = new Message(null,
                request.getMessageText(), car, client);
        messageRepository.save(message);
    }

    public List<Message> message(){
        return (List) messageRepository.findAll();
    }

    public Message messagePorId(Integer id){
        return messageRepository.findById(id).orElse(null);
    }

}
