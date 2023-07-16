package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "clients")
public class Clients extends BaseEntity {
    @Column(nullable = false)
    private String name;

    private String phonenumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clients")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Sale> sale;

    public Clients(String name, String phonenumber, Set<Sale> sale) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.sale = sale;
    }


    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Clients(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Set<Sale> getSale() {
        return sale;
    }

    public void setSale(Set<Sale> sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sale=" + sale +
                ", id=" + id +
                '}';
    }
}
