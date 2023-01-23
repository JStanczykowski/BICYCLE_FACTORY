package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Part;
import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.status;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.BikeService;
import net.javaguides.springboot.service.PartService;
import net.javaguides.springboot.service.TasksService;
import net.javaguides.springboot.service.UserService;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class EgineerController {

    private PartService partService;


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
