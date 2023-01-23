package net.javaguides.springboot.controller;

import net.javaguides.springboot.adapter.AdapterImpl;
import net.javaguides.springboot.adapter.Price;
import net.javaguides.springboot.decorator.BikeInterface;
import net.javaguides.springboot.decorator.BikeWithFS;
import net.javaguides.springboot.decorator.BikeWithHT;
import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.current;
import net.javaguides.springboot.responsibility.ChangeCAD;
import net.javaguides.springboot.responsibility.ChangeCHF;
import net.javaguides.springboot.responsibility.ChangeEuro;
import net.javaguides.springboot.responsibility.ChangeUSD;
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
        if(bike.getSize().equals("L")) {
            bike.setPrice(1000);
        }
        if(bike.getSize().equals("M")) {
            bike.setPrice(800);
        }
        if(bike.getSize().equals("S")) {
            bike.setPrice(500);
        }
        if(bike.getSize().equals("XL")) {
            bike.setPrice(1500);
        }
        bikeService.saveBike(bike);
        return "redirect:/client";
    }

    @GetMapping("/client/list/current")
    public String current(Model model){
        Bike bike = new Bike();
        model.addAttribute("bike", bike);
        return "currentWeb";
    }
    @PostMapping("/client/list/current")
    public String saveCurrent(@ModelAttribute("bike") Bike bike){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Bike> lista = new ArrayList<>();
        for(Bike listBike: bikeService.getListBike(auth,bikeService)) {
                listBike.setCurrentValue(bike.getCurrentValue());
                lista.add(listBike);
                bikeService.updateBike(listBike);

        }
        current cur = new current();
        if(lista.get(0).getCurrentValue().equals("USD")) {
            ChangeUSD changeUSD = new ChangeUSD();
            cur.setCurre(4.35);
            lista.get(0).setForeginPrice(changeUSD,lista.iterator(),cur);
        }
        if(lista.get(0).getCurrentValue().equals("CAD")) {
            ChangeCAD changeCAD = new ChangeCAD();
            cur.setCurre(3.25);
            lista.get(0).setForeginPrice(changeCAD,lista.iterator(),cur);
        }
        if(lista.get(0).getCurrentValue().equals("EUR")) {
            ChangeEuro changeEuro = new ChangeEuro();
            cur.setCurre(4.7);
            lista.get(0).setForeginPrice(changeEuro,lista.iterator(),cur);
        }
        if(lista.get(0).getCurrentValue().equals("CHF")) {
            ChangeCHF changeCHF = new ChangeCHF();
            cur.setCurre(4.72);
            lista.get(0).setForeginPrice(changeCHF,lista.iterator(),cur);
        }
        for(Bike listBike: bikeService.getListBike(auth,bikeService)) {
                bikeService.updateBike(listBike);
        }
        return "redirect:/client/list";
    }
    @GetMapping("/client/list")
    public String listBike(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<Bike> lista = bikeService.getListBike(auth,bikeService);
        model.addAttribute("bike",lista);
        return "bike_list";
    }
    @GetMapping("/client/list/fs/{id}")
    public String fs(@PathVariable Long id, @ModelAttribute("bike") Bike bike){
        Bike obj = bikeService.getBikeById(id);
        if("Niepotwierdzone".equals(obj.getActive())) {
        BikeInterface bikeInterface = new BikeWithFS(obj);

        bikeInterface.dodaj();

        bikeService.updateBike(obj);
        }
        return "redirect:/client/list";
   }
    @GetMapping("/client/list/ht/{id}")
    public String ht(@PathVariable Long id, @ModelAttribute("bike") Bike bike){
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
