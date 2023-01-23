package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Bike;
import org.springframework.security.core.Authentication;

import java.util.List;


public interface BikeService {
    List<Bike> getAllBikes();
    Bike saveBike(Bike bike);
    Bike saveBikeBuilder(Bike bike);
    Bike getBikeById(long id);
    Bike updateBike(Bike bike);
    void deleteBikeById(long id);
    Bike getBike(long id);
    List<Bike> getListBike(Authentication auth, BikeService bikeService);
}
