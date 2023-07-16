package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tours")
public class Tours extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date startdate;
    @Column(nullable = false)
    private Date enddate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Countries countries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tours")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Sale> sale;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.tours")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ToursHotels> toursHotels;

    protected Tours() {
    }

    public Tours(String name, Date startdate, Date enddate, Countries countries, Set<Sale> sale, Set<ToursHotels> toursHotels) {
        this.name = name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.countries = countries;
        this.sale = sale;
        this.toursHotels = toursHotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public Set<Sale> getSale() {
        return sale;
    }

    public void setSale(Set<Sale> sale) {
        this.sale = sale;
    }

    public Set<ToursHotels> getToursHotels() {
        return toursHotels;
    }

    public void setToursHotels(Set<ToursHotels> toursHotels) {
        this.toursHotels = toursHotels;
    }

    @Override
    public String toString() {
        return "Tours{" +
                "name='" + name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", countries=" + countries +
                ", sale=" + sale +
                ", toursHotels=" + toursHotels +
                ", id=" + id +
                '}';
    }
}
