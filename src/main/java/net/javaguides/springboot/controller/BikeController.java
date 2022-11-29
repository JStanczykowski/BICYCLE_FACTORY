package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/bike")
public class BikeController {
    private final BikeService bikeService;

    @Autowired
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("")
    public List<Bike> getBikes() {
        return bikeService.getAllBikes();
    }

    @PostMapping("/add")
    public void addBike(@RequestBody Bike bike) {
        bikeService.saveBike(bike);
    }

    @DeleteMapping("delete/{bikeid}")
    public void deleteBike(@PathVariable(name = "bikeid") long bikeId) {
        bikeService.deleteBikeById(bikeId);
    }
}
