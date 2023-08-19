package com.binaryextractcorp.restaurantlisting.service;

import com.binaryextractcorp.restaurantlisting.dto.RestaurantDTO;
import com.binaryextractcorp.restaurantlisting.entity.Restaurant;
import com.binaryextractcorp.restaurantlisting.mapper.RestaurantMapper;
import com.binaryextractcorp.restaurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants =  restaurantRepo.findAll();
        List<RestaurantDTO> restaurantDTOList = restaurants.
                stream().
                map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).
                collect(Collectors.toList());

        return  restaurantDTOList;
    }
}
