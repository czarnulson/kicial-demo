package kicialdemo.Domain.Service;

import kicialdemo.Domain.Entity.Car;
import kicialdemo.Infrastructure.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getAllByClientId(int id) {
        return carRepository.findAllByClientId(id);
    }
}
