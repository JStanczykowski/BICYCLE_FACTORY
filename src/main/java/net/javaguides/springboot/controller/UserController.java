package net.javaguides.springboot.controller;

import net.javaguides.springboot.decorator.BikeInterface;
import net.javaguides.springboot.decorator.BikeWithBlotnik;
import net.javaguides.springboot.decorator.BikeWithRabat;
import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.BikeService;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private BikeService bikeService;

    public UserController(BikeService bikeService) {
        this.bikeService = bikeService;
    }
    @GetMapping("/client")
    public String show(Model model){
        return "client";
    }
    @GetMapping("/client/new")
    public String createBike(Model model){
        Bike bike = new Bike();
        model.addAttribute("bike",bike);
        return "bike_add";
    }
    @PostMapping("/client")
    public String saveBike(@ModelAttribute("bike") Bike bike){
        bike.setActive(true);
        Random random = new Random();
        int serial=random.nextInt(500)+1;
        for(int i=0;i<bikeService.getAllBikes().size();i++) {
            if(bikeService.getAllBikes().get(i).getSerialNumber()==serial){
                serial=random.nextInt(500)+1;
                i=0;
            }
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        bike.setNumberOwner(auth.getName());
        bike.setSerialNumber(serial);

        bikeService.saveBike(bike);
        return "redirect:/client";
    }

    @GetMapping("/client/list")
    public String listBike(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Bike> lista = new ArrayList<Bike>();
        for(int i=0;i<bikeService.getAllBikes().size();i++) {
            if(bikeService.getAllBikes().get(i).getNumberOwner()==auth.getName()){
                lista.add(bikeService.getAllBikes().get(i));
            }
        }
        model.addAttribute("bike",lista);
        return "bike_list";
    }
    @GetMapping("/client/list/{id}")
    public String blotnik(@PathVariable Long id, @ModelAttribute("bike") Bike bike){
        Bike obj = bikeService.getBikeById(id);
        BikeInterface bikeInterface = new BikeWithBlotnik(obj);

        bikeInterface.dodaj();

        bikeService.updateBike(obj);
        return "redirect:/client/list";
    }
}
