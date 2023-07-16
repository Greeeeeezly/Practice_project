package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.models.Hotels;
import com.example.springdatabasicdemo.models.Tours;
import com.example.springdatabasicdemo.models.ToursHotels;
import com.example.springdatabasicdemo.repositories.ToursRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
    public class ToursService {
    private final ToursRepo toursRepository;

    public ToursService(ToursRepo toursRepository) {
        this.toursRepository = toursRepository;
    }

    /*public List<Hotels> getHotelsByTourId(Integer tourId) {
            Optional<Tours> tourOptional = toursRepository.findById(tourId);
            if (tourOptional.isPresent()) {
                Tours tour = tourOptional.get();
                Set<ToursHotels> toursHotels = tour.getToursHotels();
                List<Hotels> hotelsList = new ArrayList<>();
                for (ToursHotels tourHotel : toursHotels) {
                    hotelsList.add(tourHotel.getId().getHotels());
                }
                return hotelsList;
            } else {
                // Обработка случая, когда тур с указанным id не найден
                throw new RuntimeException("Tour not found");
            }
    }*/
    public List<HotelsDto> getHotelsByTourId(Integer tourId) {
        Optional<Tours> tourOptional = toursRepository.findById(tourId);
        if (tourOptional.isPresent()) {
            Tours tours = tourOptional.get();
            Set<ToursHotels> toursHotels = tours.getToursHotels();
            List<HotelsDto> hotelsDtoList = new ArrayList<>();
            for (ToursHotels tourHotel : toursHotels) {
                Hotels hotels = tourHotel.getId().getHotels();
                HotelsDto hotelsDto = mapToHotelDto(hotels);
                hotelsDtoList.add(hotelsDto);
            }
            return hotelsDtoList;
        } else {
            // Обработка случая, когда тур с указанным id не найден
            throw new RuntimeException("Tour not found");
        }
    }
    private HotelsDto mapToHotelDto(Hotels hotels) {
        // Логика маппинга объекта Hotel на объект HotelDto
        HotelsDto hotelsDto = new HotelsDto();
        hotelsDto.setName(hotels.getName());
        hotelsDto.setAddress(hotels.getAddress());
        hotelsDto.setRating(hotels.getRating());
        return hotelsDto;
    }

}
