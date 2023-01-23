package net.javaguides.springboot.controller;
import net.javaguides.springboot.service.BikeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BikeController {
    private final BikeService bikeService;


    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/engineer/bike")
    public String ListBike(Model model) {

        model.addAttribute("bike", bikeService.getAllBikes());
        return "bike";
    }




}
