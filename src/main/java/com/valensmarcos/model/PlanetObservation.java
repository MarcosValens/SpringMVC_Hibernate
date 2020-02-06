package com.valensmarcos.model;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuari_has_planeta")
@Audited
public class PlanetObservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "planeta_idplaneta")
    private Planet planet;

    @ManyToOne
    @JoinColumn(name = "usuari_idusuari")
    @Type(type = "User")
    private User user;

    private String observations;

    public PlanetObservation() {
    }

    public PlanetObservation(Planet planet, User user, String observations) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetObservation that = (PlanetObservation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(planet, that.planet) &&
                Objects.equals(user, that.user) &&
                Objects.equals(observations, that.observations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planet, user, observations);
    }

    @Override
    public String toString() {
        return "PlanetObservation{" +
                "id=" + id +
                ", planet=" + planet +
                ", user=" + user +
                ", observations='" + observations + '\'' +
                '}';
    }
}
