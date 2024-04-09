package tqs.homework_assignment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testSaveReservation() {
        Reservation reservation = new Reservation(5000, "Origin", "Destination", "2022-01-01", 100.0);
        Reservation savedReservation = reservationRepository.save(reservation);
        assertEquals(reservation.getTimestamp(), savedReservation.getTimestamp());
    }

    @Test
    void testFindById() {
        Trip trip = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        entityManager.persist(trip);
        entityManager.flush();
        Reservation reservation = new Reservation();

        reservation.setTrip(trip);
        reservation.setTimestamp();
        entityManager.persist(reservation);
        entityManager.flush();

        Reservation foundReservation = reservationRepository.findById( (long) reservation.getId()).orElse(null);
        assertNotNull(foundReservation);
        assertEquals(reservation.getId(), foundReservation.getId());

    }

    @Test
    void testDeleteReservation() {
        Trip trip = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        entityManager.persist(trip);
        entityManager.flush();
        Reservation reservation = new Reservation();

        reservation.setTrip(trip);
        reservation.setTimestamp();
        entityManager.persist(reservation);
        entityManager.flush();

        reservationRepository.delete(reservation);
        assertFalse(reservationRepository.findById( (long) reservation.getId()).isPresent());
    }
}