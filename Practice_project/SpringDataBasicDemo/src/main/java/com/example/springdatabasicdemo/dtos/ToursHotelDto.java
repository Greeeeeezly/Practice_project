package com.example.springdatabasicdemo.dtos;



public class ToursHotelDto {
    private int id;
    private ToursDto tours;
    private HotelsDto hotels;

    public ToursHotelDto(int id, ToursDto tours, HotelsDto hotels) {
        this.id = id;
        this.tours = tours;
        this.hotels = hotels;
    }

    public ToursHotelDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ToursDto getTours() {
        return tours;
    }

    public void setTours(ToursDto tours) {
        this.tours = tours;
    }

    public HotelsDto getHotels() {
        return hotels;
    }

    public void setHotels(HotelsDto hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "ToursHotelDto{" +
                "id=" + id +
                ", tours=" + tours +
                ", hotels=" + hotels +
                '}';
    }
}
