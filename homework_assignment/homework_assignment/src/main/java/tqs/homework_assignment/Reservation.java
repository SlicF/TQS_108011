package tqs.homework_assignment;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Reservation() {
    }

    public Reservation(int id, String origin, String destination, String date, Double priceEuro) {
        this.id = id;
        this.trip = new Trip(origin, destination, date, priceEuro);
        this.timestamp = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", trip=" + trip +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Reservation reservation = (Reservation) obj;
        return id == reservation.id && trip.equals(reservation.trip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trip);
    }
    

}
