package com.valensmarcos.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuari")
public class User {

    @Id
    @Column(name = "idusuari")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String userName;

    @Column
    private String password;

    @Column(name = "nom")
    private String name;

    @Column(name = "cognoms")
    private String secondName;

    @OneToMany(mappedBy = "user")
    private List<PlanetObservation> planetObservations;

    public User() {
    }

    public User(int id, String userName, String name, String secondName) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(secondName, user.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, name, secondName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
