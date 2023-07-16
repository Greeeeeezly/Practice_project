package com.example.springdatabasicdemo.dtos;



public class SaleDto {
    private int id;
    private ClientsDto clients;
    private ToursDto tours;

    public SaleDto(int id, ClientsDto clients, ToursDto tours) {
        this.id = id;
        this.clients = clients;
        this.tours = tours;
    }

    public SaleDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientsDto getClients() {
        return clients;
    }

    public void setClients(ClientsDto clients) {
        this.clients = clients;
    }

    public ToursDto getTours() {
        return tours;
    }

    public void setTours(ToursDto tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "SaleDto{" +
                "id=" + id +
                ", clients=" + clients +
                ", tours=" + tours +
                '}';
    }
}
