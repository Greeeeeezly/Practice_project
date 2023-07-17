package com.example.springdatabasicdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ToursHotelsId implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "tour_id", referencedColumnName = "id", nullable=false)
    @JsonIgnore // Добавьте эту аннотацию, чтобы предотвратить сериализацию циклической связи
    private Tours tours;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable=false)
    @JsonIgnore // Добавьте эту аннотацию, чтобы предотвратить сериализацию циклической связи
    private Hotels hotels;

    public ToursHotelsId(Tours tours, Hotels hotels) {
        this.tours = tours;
        this.hotels = hotels;
    }

    public Tours getTours() {
        return tours;
    }

    public void setTours(Tours tours) {
        this.tours = tours;
    }

    public Hotels getHotels() {
        return hotels;
    }

    public void setHotels(Hotels hotels) {
        this.hotels = hotels;
    }

    protected ToursHotelsId() {
    }

}
