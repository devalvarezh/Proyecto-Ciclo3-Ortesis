package com.AlquilerOrtesis.Ortesis3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ortopedic")
public class Ortopedic {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    //Relation using foreign key into product
    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("ortopedics")
    private Category category;

    //Make inverse relation with message table
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic")
    @JsonIgnoreProperties({"ortopedic", "client"})
    private List<Message> messages;

    //Make inverse relation with reservation table
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic")
    @JsonIgnoreProperties({"ortopedic", "message"})
    private List<Reservation> reservations;

    //Getters and Setters


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
