package tqs.cars;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class CarController {

    private final CarManagerService carManagerService;

    public CarController(CarManagerService carManagerService) {
        this.carManagerService = carManagerService;
    }

    @PostMapping("/newcar")
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        car.setModel(carDTO.getModel());
        car.setMaker(carDTO.getMaker());

        Car savedCar = carManagerService.save(car);
        CarDTO savedCarDTO = new CarDTO();
        savedCarDTO.setModel(savedCar.getModel());
        savedCarDTO.setMake(savedCar.getMaker());

        return new ResponseEntity<>(savedCarDTO, HttpStatus.CREATED);
    }

    @GetMapping("/allcars")
    public List<Car> getAllCars() {
        return carManagerService.getAllCars();
    }

    @GetMapping("/car/{carID}")
    public ResponseEntity<Car> getCarById(@PathVariable Long carID) {
        Car car = carManagerService.getCarDetails(carID);
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

}
