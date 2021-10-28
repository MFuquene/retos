package com.usa.app.g24.rentas.service;

import com.usa.app.g24.rentas.dto.GamaRequest;
import com.usa.app.g24.rentas.model.Gama;
import com.usa.app.g24.rentas.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GamaService {
    @Autowired
    private GamaRepository gamaRepository;

    public void guardar(GamaRequest request) throws Exception {

        if (existeGama(request.getName())){
            throw new Exception("Gama ya existe");
        }
        Gama gama = new Gama(null, request.getName(),
                request.getDescription());
        gamaRepository.save(gama);
    }

    public List<Gama> gama() {
        return (List) gamaRepository.findAll();
    }

    public Gama gamaPorId(Integer id){
        return gamaRepository.findById(id).orElse(null);
    }

    private  boolean existeGama(String name){
        Gama  gama = gamaRepository.findByName(name);
        if (gama == null){
            return false;
        } else {
            return true;
        }
    }
}