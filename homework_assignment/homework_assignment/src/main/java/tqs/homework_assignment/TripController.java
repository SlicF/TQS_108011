package tqs.homework_assignment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trips")
class TripController {

    private final TripRepository tripRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public TripController(TripRepository tripRepository, ReservationRepository reservationRepository) {
        this.tripRepository = tripRepository;
        this.reservationRepository = reservationRepository;
    }


    @GetMapping("/search")
    List<Trip> searchTrips(@RequestParam String origin, @RequestParam String destination,
            @RequestParam String date) {
        List<Trip> trips = new ArrayList<>();
        for (Trip trip : tripRepository.findAll()) {
            if (trip.getOrigin().equals(origin) && trip.getDestination().equals(destination) && trip.getDate().equals(date)) {
                trips.add(trip);
            }
        }
        return trips;
    }

    @PostMapping("/reserve")
    Reservation createReservation(@RequestBody Trip trip) {
        Reservation reservation = new Reservation();
        Trip managedTrip = tripRepository.findById((long)trip.getId()).orElse(null);
        reservation.setTrip(managedTrip);
        reservation.setTimestamp();
        reservationRepository.save(reservation);
        return reservation;
    }

    @GetMapping("/reservations/{id}")
    Reservation getReservation(@PathVariable String id) {
        // delete every reservation older than 30 seconds
        for (Reservation reservation : reservationRepository.findAll()) {
            if (reservation.getTimestamp().plusSeconds(30).isBefore(LocalDateTime.now())) {
                reservationRepository.delete(reservation);
            }
        }
        return reservationRepository.findById(Long.parseLong(id)).orElse(null);
    }
}