package net.javaguides.springboot.controller;
import net.javaguides.springboot.model.Part;
import net.javaguides.springboot.model.status;
import net.javaguides.springboot.service.PartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EgineerController {

    private final PartService partService;


    public EgineerController(PartService partService){this.partService =partService;}


    @GetMapping("/engineer")
    public String main(){
        return"engineer";
    }
    @GetMapping("/engineer/part")
    public String ListParts(Model model){


        model.addAttribute("part", partService.getAllParts());
        return "part";
    }
    @GetMapping("/engineer/part/{id}")
    public String emptyTask(@PathVariable Long id) {
        Part part = partService.getPartById(id);
        part.setStat(status.more);

        partService.updatePart(part);
        return "redirect:/engineer/part";
    }

}
