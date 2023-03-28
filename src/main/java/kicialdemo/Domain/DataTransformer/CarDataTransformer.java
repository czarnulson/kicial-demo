package kicialdemo.Domain.DataTransformer;

import kicialdemo.Domain.Entity.Car;
import kicialdemo.Domain.ValueObject.CarValueObject;
import org.springframework.stereotype.Service;

@Service
public class CarDataTransformer {

    public CarValueObject transform(Car car) {
        return new CarValueObject(car.getId(), car.getBrand(), car.getRegistrationNumber());
    }
}
