package com.usa.app.g24.rentas.service;

import com.usa.app.g24.rentas.dto.ClientRequest;
import com.usa.app.g24.rentas.model.Client;
import com.usa.app.g24.rentas.model.Message;
import com.usa.app.g24.rentas.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void guardar(ClientRequest request) throws  Exception {

        Client client = new Client(null, request.getEmail(),
                request.getPassword(), request.getName(), request.getAge());
        clientRepository.save(client);
    }

    public List<Client> client(){
        return (List) clientRepository.findAll();
    }

    public Client clientPorId(Integer id){
        return clientRepository.findById(id).orElse(null);
    }
}
