package com.usa.app.g24.rentas.service;

import com.usa.app.g24.rentas.dto.CarRequest;
import com.usa.app.g24.rentas.model.Car;
import com.usa.app.g24.rentas.model.Gama;
import com.usa.app.g24.rentas.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private GamaService gamaService;

    public void guardar(CarRequest request) throws Exception {
        Gama gama = gamaService.gamaPorId(request.getGama().getIdGama());

        if (gama == null){
            throw new Exception("Hace falta la Gama");
        }

        Car car = new Car(null, request.getName(), request.getBrand(),
                request.getYear(), request.getDescription(), gama);
        carRepository.save(car);
    }

    public List<Car> car(){
        return (List) carRepository.findAll();
    }

    public Car carPorId(Integer id){
        return carRepository.findById(id).orElse(null);
    }
}
