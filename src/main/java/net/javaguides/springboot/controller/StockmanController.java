package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Part;
import net.javaguides.springboot.model.status;
import net.javaguides.springboot.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StockmanController {
    private PartService partService;


    public StockmanController(PartService partService){this.partService =partService;}



    @GetMapping("/stockman")
    public String ListParts(Model model){


        model.addAttribute("part", partService.getAllParts());
        return "stockman";
    }
    @GetMapping("/stockman/edit/{id}")
    public String editPartForm(@PathVariable Long id,Model model){
        model.addAttribute("part",partService.getPartById(id));
        return "edit_stockman";
    }
    @PostMapping("/stockman/{id}")
    public String updatePart(@PathVariable Long id, @ModelAttribute("part") Part part){
        Part existingPart = partService.getPartById(id);

        existingPart.setIlosc(part.getIlosc());

        existingPart.setStat(part.getStat());
        if(existingPart.getStat()==status.ok){
            existingPart.setStatusOrder("Czesci dostepne");
        }
        partService.updatePart(existingPart);
        return "redirect:/stockman";
    }

}
