package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "countries")
public class Countries extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "countries")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Tours> tours;

    public Countries(String name, Set<Tours> tours) {
        this.name = name;
        this.tours = tours;
    }

    protected Countries() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Tours> getTours() {
        return tours;
    }

    public void setTours(Set<Tours> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "name='" + name + '\'' +
                ", tours=" + tours +
                ", id=" + id +
                '}';
    }
}
