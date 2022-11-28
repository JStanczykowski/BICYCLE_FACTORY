package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Bike;

import java.util.List;


public interface BikeService {
    List<Bike> getAllBikes();
    Bike saveBike(Bike bike);
    Bike getBikeById(long id);
    Bike updateBike(Bike bike);
    void deleteBikeById(long id);
    Bike getBike(long id);
}
