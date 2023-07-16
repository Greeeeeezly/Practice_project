package com.example.springdatabasicdemo.models;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "hotels")
public class Hotels extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Integer rating;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.hotels")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ToursHotels> toursHotels;

    protected Hotels() {
    }

    public Hotels(String name, String address, Integer rating, Set<ToursHotels> toursHotels) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.toursHotels = toursHotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Set<ToursHotels> getToursHotels() {
        return toursHotels;
    }

    public void setToursHotels(Set<ToursHotels> toursHotels) {
        this.toursHotels = toursHotels;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "name='" + name + '\'' +
                ", adress='" + address + '\'' +
                ", rating=" + rating +
                ", toursHotels=" + toursHotels +
                ", id=" + id +
                '}';
    }
}
