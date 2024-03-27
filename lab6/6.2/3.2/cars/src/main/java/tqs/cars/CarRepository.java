package tqs.cars;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer>{
    
    public Car findByCarId(Long carID);
    public List<Car> findAll();
    
}
