package tqs.homework_assignment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void testGetId() {
        Reservation reservation = new Reservation(1, "Origin", "Destination", "2022-01-01", 100.0);
        assertEquals(1, reservation.getId());
    }

    @Test
    void testGetTrip() {
        Reservation reservation = new Reservation(1, "Origin", "Destination", "2022-01-01", 100.0);
        Trip trip = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        assertEquals(trip, reservation.getTrip());
    }

    @Test
    void testSetId() {
        Reservation reservation = new Reservation();
        reservation.setId(1);
        assertEquals(1, reservation.getId());
    }

    @Test
    void testSetTrip() {
        Reservation reservation = new Reservation();
        Trip trip = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        reservation.setTrip(trip);
        assertEquals(trip, reservation.getTrip());
    }

    @Test
    void testGetTimestamp() {
        Reservation reservation = new Reservation(1, "Origin", "Destination", "2022-01-01", 100.0);
        assertNotNull(reservation.getTimestamp());
    }

    @Test
    void testSetTimestamp() {
        Reservation reservation = new Reservation();
        reservation.setTimestamp();
        assertNotNull(reservation.getTimestamp());
    }

    @Test
    void testToString() {
        Reservation reservation = new Reservation(1, "Origin", "Destination", "2022-01-01", 100.0);
        String expected = "Reservation{id='1', trip=Trip{origin='Origin', destination='Destination', date='2022-01-01', priceEuro=100.0}, timestamp=" + reservation.getTimestamp() + "}";
        assertEquals(expected, reservation.toString());
    }

    @Test
    void testEquals() {
        Reservation reservation1 = new Reservation(1, "Origin", "Destination", "2022-01-01", 100.0);
        Reservation reservation2 = new Reservation(1, "Origin", "Destination", "2022-01-01", 100.0);
        assertEquals(reservation1, reservation2);
    }
}