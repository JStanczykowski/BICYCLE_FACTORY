package net.javaguides.springboot.controller;

import net.javaguides.springboot.adapter.AdapterImpl;
import net.javaguides.springboot.adapter.Price;
import net.javaguides.springboot.decorator.BikeInterface;
import net.javaguides.springboot.decorator.BikeWithFS;
import net.javaguides.springboot.decorator.BikeWithHT;
import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.service.BikeService;
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

@Controller
public class UserController {
    private BikeService bikeService;

    public UserController(BikeService bikeService) {
        this.bikeService = bikeService;
    }
    @GetMapping("/client")
    public String show(){
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
        bike.setActive("Niepotwierdzone");
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
        bike.setPrice(1000);
        bikeService.saveBike(bike);
        return "redirect:/client";
    }

    @GetMapping("/client/list")
    public String listBike(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Bike> lista = new ArrayList<>();
        for(int i=0;i<bikeService.getAllBikes().size();i++) {
            if(bikeService.getAllBikes().get(i).getNumberOwner().equals(auth.getName())){
                lista.add(bikeService.getAllBikes().get(i));
            }
        }
        model.addAttribute("bike",lista);
        return "bike_list";
    }
    @GetMapping("/client/list/blotnik/{id}")
    public String blotnik(@PathVariable Long id, @ModelAttribute("bike") Bike bike){
        Bike obj = bikeService.getBikeById(id);
      //  if(obj.getActive()=="Niepotwierdzone") {
        BikeInterface bikeInterface = new BikeWithFS(obj);

        bikeInterface.dodaj();

        bikeService.updateBike(obj);//}
        return "redirect:/client/list";
   }
    @GetMapping("/client/list/swiatla/{id}")
    public String swiatla(@PathVariable Long id, @ModelAttribute("bike") Bike bike){
        Bike obj = bikeService.getBikeById(id);
        if("Niepotwierdzone".equals(obj.getActive())) {
            BikeInterface bikeInterface = new BikeWithHT(obj);

            bikeInterface.dodaj();

            bikeService.updateBike(obj);
        }
        return "redirect:/client/list";
    }
    @GetMapping("/client/list/order/{id}")
    public String orderek(@PathVariable Long id, @ModelAttribute("bike") Bike bike) {
        Bike bik = bikeService.getBikeById(id);
        bik.setActive("Zamowiony");

        bikeService.updateBike(bik);
        return "redirect:/client/list";
    }
    @GetMapping("/client/list/change/{id}")
    public String change(@PathVariable Long id, @ModelAttribute("bike") Bike bike) {
        Bike bik = bikeService.getBikeById(id);
       Price price = new AdapterImpl(bik);
        bik.setPrice(price.getPriceInt());
        bikeService.updateBike(bik);
        return "redirect:/client/list";
    }
}
