package com.valensmarcos.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "satelit")
public class Satellite {

    @Id
    @Column(name = "idsatelit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom", nullable = false)
    private String name;

    @Column(name = "massa")
    private long mass;

    @Column(name = "velocitat")
    private int speed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planeta_idplaneta", foreignKey = @ForeignKey(name = "idplaneta"))
    private Planet planet;

    public Satellite() {
    }

    public Satellite(int id, String name, long mass, int speed, Planet planet) {
        this.id = id;
        this.name = name;
        this.mass = mass;
        this.speed = speed;
        this.planet = planet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMass() {
        return mass;
    }

    public void setMass(long mass) {
        this.mass = mass;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Satellite satellite = (Satellite) o;
        return id == satellite.id &&
                mass == satellite.mass &&
                speed == satellite.speed &&
                Objects.equals(name, satellite.name) &&
                Objects.equals(planet, satellite.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mass, speed, planet);
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mass=" + mass +
                ", speed=" + speed +
                ", planet=" + planet +
                '}';
    }
}
