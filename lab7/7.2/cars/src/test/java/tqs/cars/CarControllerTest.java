package tqs.cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService carManagerService;


    @BeforeEach
    void start() {
        RestAssuredMockMvc.mockMvc(mvc);
    }

    @Test
    void createCar( ) throws Exception {
        Car car = new Car( "Ferrari", "Enzo" );

        when( carManagerService.save( Mockito.any() )).thenReturn(car) ;

        mvc.perform(
                post("/newcar").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(car)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.maker", is("Ferrari")))
                .andExpect(jsonPath("$.model", is("Enzo")));

        verify(carManagerService, times(1)).save(Mockito.any());
    }


    @Test
    void getAllCarsTest() throws Exception {

        Car car_1 = new Car( "Ferrari", "Enzo" );
        Car car_2 = new Car( "Audi", "Quattro" );
        Car car_3 = new Car( "Volkswagen", "Polo" );

        List<Car> allCars = Arrays.asList(car_1, car_2, car_3);

        when(carManagerService.getAllCars()).thenReturn(allCars);

        mvc.perform(
            get("/allcars").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[0].maker", is(car_1.getMaker())))
            .andExpect(jsonPath("$[0].model", is(car_1.getModel())))
            .andExpect(jsonPath("$[1].maker", is(car_2.getMaker())))
            .andExpect(jsonPath("$[1].model", is(car_2.getModel())))
            .andExpect(jsonPath("$[2].maker", is(car_3.getMaker())))
            .andExpect(jsonPath("$[2].model", is(car_3.getModel())));
            
        verify(carManagerService, times(1)).getAllCars();

    }


    @Test
    void getCarTest() throws Exception {

        Car car = new Car( "Ferrari", "Enzo" );

        when( carManagerService.getCarDetails(Mockito.any())).thenReturn(car);

        mvc.perform(
            get("/car/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.maker", is(car.getMaker())))
            .andExpect(jsonPath("$.model", is(car.getModel())));

        verify(carManagerService, times(1)).getCarDetails( Long.valueOf(1) );

    }
    
}
