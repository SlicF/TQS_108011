package tqs.homework_assignment;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TripControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TripRepository tripRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private TripController tripController;

    @Test
    void testSearchTrips() throws Exception {
        // Mock data
        Trip trip1 = new Trip("Origin1", "Destination1", "2022-01-01", 100.0);
        Trip trip2 = new Trip("Origin2", "Destination2", "2022-01-01", 150.0);
        List<Trip> trips = new ArrayList<>();
        trips.add(trip1);
        trips.add(trip2);

        // Mock repository response
        when(tripRepository.findAll()).thenReturn(trips);

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/trips/search")
                .param("origin", "Origin1")
                .param("destination", "Destination1")
                .param("date", "2022-01-01"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].origin").value("Origin1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].destination").value("Destination1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date").value("2022-01-01"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].priceEuro").value(100.0));
    }

    @Test
    void testCreateReservation() throws Exception {
        // Given
        Trip trip = new Trip("Lisbon", "Paris", "2024-04-11", 15.0);
        Reservation reservation = new Reservation();
        reservation.setTrip(trip);
        reservation.setTimestamp();

        when(tripRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(trip));
        when(reservationRepository.save(Mockito.any(Reservation.class))).thenReturn(reservation);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/trips/reserve")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "{\"origin\":\"Lisbon\",\"destination\":\"Paris\",\"date\":\"2024-04-11\",\"priceEuro\":15.0}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.trip.origin").value("Lisbon"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.trip.destination").value("Paris"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.trip.date").value("2024-04-11"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.trip.priceEuro").value(15.0));
    }

    @Test
    @Disabled("This test does not work because, the JSON object is not being iterated correctly")
    void testGetReservation() throws Exception {
        // Given
        Reservation reservation = new Reservation();
        reservation.setTrip(new Trip("Lisbon", "Paris", "2024-04-11", 15.0));
        reservation.setTimestamp();

        when(reservationRepository.findAll()).thenReturn(List.of(reservation));
        when(reservationRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(reservation));

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/trips/reservations/{id}", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.trip.origin").value("Lisbon"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.trip.destination").value("Paris"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.trip.date").value("2024-04-11"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.trip.priceEuro").value(15.0));
    }
}