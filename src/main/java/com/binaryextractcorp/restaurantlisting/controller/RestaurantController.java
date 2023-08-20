package com.binaryextractcorp.restaurantlisting.controller;

import com.binaryextractcorp.restaurantlisting.dto.RestaurantDTO;
import com.binaryextractcorp.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
        List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> saverestaurent(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurantDTOAdded = restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantDTOAdded,HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantById/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable Integer id){
        return restaurantService.fetchRestaurantById(id);
    }

}
