package com.valensmarcos.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "planeta")
public class Planet {
    @Id
    @Column(name = "idplaneta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String name;

    @Column(name = "massa")
    private long mass;

    @Column(name = "habitable")
    private byte habitable;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "planet", orphanRemoval = true)
    //preguntar si el mapped hace referencia  al nombre de la variable Planeta que tiene satelite o al nombre que tiene la relacion (tabla) entre ambas entidades
    private List<Satellite> satellites;

    @OneToMany(mappedBy = "planet")
    private List<PlanetObservation> planetObservations;

    public Planet() {
    }

    public Planet(int id, String name, long mass, byte habitable) {
        this.id = id;
        this.name = name;
        this.mass = mass;
        this.habitable = habitable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public byte getHabitable() {
        return habitable;
    }

    public void setHabitable(byte habitable) {
        this.habitable = habitable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.id &&
                mass == planet.mass &&
                habitable == planet.habitable &&
                Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mass, habitable);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mass=" + mass +
                ", habitable=" + habitable +
                '}';
    }
}
