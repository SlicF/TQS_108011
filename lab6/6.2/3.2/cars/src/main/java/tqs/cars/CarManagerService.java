package tqs.cars;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarManagerService {

    private final CarRepository carRepository;

    public CarManagerService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public Car save(Car car) {
        return carRepository.save(car);
    }
    
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarDetails(Long carID) {
        return carRepository.findByCarId(carID);
    }
}
