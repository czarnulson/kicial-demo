package kicialdemo.Application.Controller;

import kicialdemo.Domain.DataTransformer.CarDataTransformer;
import kicialdemo.Domain.Service.CarService;
import kicialdemo.Domain.ValueObject.CarValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    CarDataTransformer carDataTransformer;

    @GetMapping("/{clientId}")
    public List<CarValueObject> getAllByClientId(@PathVariable("clientId") int clientId) {
        return carService.getAllByClientId(clientId).stream().map(carDataTransformer::transform).toList();
    }
}
