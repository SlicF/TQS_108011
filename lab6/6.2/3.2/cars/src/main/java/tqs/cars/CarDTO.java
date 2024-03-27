package tqs.cars;

public class CarDTO {
    private Long carID;
    private String maker;
    private String model;

    public static CarDTO fromCarEntity(Car car) {
        return new CarDTO(car.getMaker(), car.getModel());
    }

    public Car toCarEntity() {
        return new Car(getMaker(), getModel());
    }

    public CarDTO() {
    }

    public CarDTO(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public String getMaker() {
        return maker;
    }

    public void setMake(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}