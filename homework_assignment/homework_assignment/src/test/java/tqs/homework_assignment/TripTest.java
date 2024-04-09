package tqs.homework_assignment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TripTest {

    @Test
    void testGetOrigin() {
        Trip trip = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        assertEquals("Origin", trip.getOrigin());
    }

    @Test
    void testGetDestination() {
        Trip trip = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        assertEquals("Destination", trip.getDestination());
    }

    @Test
    void testGetDate() {
        Trip trip = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        assertEquals("2022-01-01", trip.getDate());
    }

    @Test
    void testSetOrigin() {
        Trip trip = new Trip();
        trip.setOrigin("Origin");
        assertEquals("Origin", trip.getOrigin());
    }

    @Test
    void testSetDestination() {
        Trip trip = new Trip();
        trip.setDestination("Destination");
        assertEquals("Destination", trip.getDestination());
    }

    @Test
    void testSetDate() {
        Trip trip = new Trip();
        trip.setDate("2022-01-01");
        assertEquals("2022-01-01", trip.getDate());
    }

    @Test
    void testGetPriceEuro() {
        Trip trip = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        assertEquals(100.0, trip.getPriceEuro());
    }

    @Test
    void testSetPriceEuro() {
        Trip trip = new Trip();
        trip.setPriceEuro(100.0);
        assertEquals(100.0, trip.getPriceEuro());
    }

    @Test
    void testGetId() {
        Trip trip = new Trip();
        trip.setId(1);
        assertEquals(1, trip.getId());
    }

    @Test
    void testToString() {
        Trip trip = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        String expected = "Trip{origin='Origin', destination='Destination', date='2022-01-01', priceEuro=100.0}";
        assertEquals(expected, trip.toString());
    }

    @Test
    void testEquals() {
        Trip trip1 = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        Trip trip2 = new Trip("Origin", "Destination", "2022-01-01", 100.0);
        assertEquals(trip1, trip2);
    }
}