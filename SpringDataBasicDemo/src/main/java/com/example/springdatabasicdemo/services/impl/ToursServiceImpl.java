package com.example.springdatabasicdemo.services.impl;
import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.dtos.ToursDto;
import com.example.springdatabasicdemo.models.Hotels;
import com.example.springdatabasicdemo.models.Tours;
import com.example.springdatabasicdemo.models.ToursHotels;
import com.example.springdatabasicdemo.repositories.ToursRepo;
import com.example.springdatabasicdemo.services.ToursService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
    public class ToursServiceImpl implements ToursService<Integer> {
    @Autowired
    private ToursRepo toursRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ToursDto register(ToursDto tours) {
        Tours t = modelMapper.map(tours, Tours.class);
        return modelMapper.map(toursRepo.save(t), ToursDto.class);
    }

    @Override
    public void delete(ToursDto tours) {
        toursRepo.deleteById(tours.getId());
    }

    @Override
    public void delete(Integer id) {
        toursRepo.deleteById(id);
    }


    @Override
    public Optional<ToursDto> findTours(Integer id) {
        return Optional.ofNullable(modelMapper.map(toursRepo.findById(id), ToursDto.class));
    }

    @Override
    public List<ToursDto> getAll() {
        return toursRepo.findAll().stream().map((s) -> modelMapper.map(s, ToursDto.class)).collect(Collectors.toList());
    }

    @Transactional
    public List<HotelsDto> getHotelsByTourId(Integer tourId) {
        Optional<Tours> tourOptional = toursRepo.findById(tourId);
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
