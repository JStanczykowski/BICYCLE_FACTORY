package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.model.TypeTask;
import net.javaguides.springboot.service.BikeService;
import net.javaguides.springboot.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BikeController {
    private BikeService bikeService;


    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/engineer/bike")
    public String ListBike(Model model) {

        model.addAttribute("bike", bikeService.getAllBikes());
        return "bike";
    }




}
