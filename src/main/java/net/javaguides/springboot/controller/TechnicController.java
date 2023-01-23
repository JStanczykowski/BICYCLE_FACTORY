package net.javaguides.springboot.controller;
import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.service.TasksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class TechnicController {
    private final TasksService tasksService;


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





}
