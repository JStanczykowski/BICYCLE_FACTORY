package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.Part;
import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.model.TypeTask;
import net.javaguides.springboot.repository.TasksRepo;
import net.javaguides.springboot.service.BikeService;
import net.javaguides.springboot.service.TasksService;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class TechnicController {
    private TasksService tasksService;

    private BikeService bikeService;

    public TechnicController(TasksService tasksService
                           ){this.tasksService =tasksService;


    }
    @GetMapping("/technic")
    public String ListTasks(Model model){
        Predicate<Tasks> byDone = tasks -> tasks.getDone().equals(false);
        List<Tasks> result = tasksService.getAllTasks().stream().filter(byDone)
                .collect(Collectors.toList());
        model.addAttribute("technic", result);
        return "technic";
    }
    @GetMapping("/technic/instruction/{id}")
   public String InstructionTask(@PathVariable Long id, Model model){
        model.addAttribute("technic", tasksService.getTaskById(id));
        return "instruction";
    }
    @PostMapping("/technic/{id}")
    public String saveTask(@PathVariable Long id,@ModelAttribute("technic") Tasks tasks) {
        Tasks obj = tasksService.getTaskById(id);
        obj.setDone(true);

        tasksService.updateTask(obj);
        return "redirect:/technic";
    }



}
