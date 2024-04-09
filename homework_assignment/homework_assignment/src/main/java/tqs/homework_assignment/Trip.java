package tqs.homework_assignment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "date")
    private String date;

    @Column(name = "price_euro")
    private Double priceEuro;

    public Trip() {
    }

    public Trip(String origin, String destination, String date, Double priceEuro) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.priceEuro = priceEuro;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPriceEuro() {
        return priceEuro;
    }

    public void setPriceEuro(Double priceEuro) {
        this.priceEuro = priceEuro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' + ", priceEuro=" + priceEuro +
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
        Trip trip = (Trip) obj;
        return origin.equals(trip.origin) && destination.equals(trip.destination) && date.equals(trip.date)
                && priceEuro.equals(trip.priceEuro);
    }

    @Override
    public int hashCode() {
        return origin.hashCode() + destination.hashCode() + date.hashCode() + priceEuro.hashCode();
    }
}
