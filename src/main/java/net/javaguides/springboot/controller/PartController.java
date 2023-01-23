package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Part;
import net.javaguides.springboot.model.status;
import net.javaguides.springboot.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class PartController {
    private PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/client/add_part")
    public String addPart(Model model){
        Part part = new Part();
        model.addAttribute("part",part);
        return "add_part";
    }
    @PostMapping("/client/add_part")
    public String savePart(@ModelAttribute("part") Part part){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        part.setNumberOwner(auth.getName());
        part.setStat(status.valueOf("more"));
        part.setStatusOrder("Zamowione");
        Random random = new Random();
        int serial=random.nextInt(500)+1;
        for(int i=0;i<partService.getAllParts().size();i++) {
            if(partService.getAllParts().get(i).getCatalogNumber()==serial){
                serial=random.nextInt(500)+1;
                i=0;
            }
        }
        part.setCatalogNumber(serial);
        partService.savePart(part);
        if(auth.getAuthorities().toString().equals("[INZYNIER]"))
            return "redirect:/engineer/part";
        else
            return "redirect:/client";
    }
    @GetMapping("/client/part")
    public String part(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Part> lista = new ArrayList<>();
        for(int i=0;i<partService.getAllParts().size();i++) {
            if(partService.getAllParts().get(i).getNumberOwner().equals(auth.getName())){

                lista.add(partService.getAllParts().get(i));
            }
        }
        model.addAttribute("part",lista);
        return "part_client";
    }
}
