package net.javaguides.springboot.controller;

import net.javaguides.springboot.service.TasksService;
import net.javaguides.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/technic")
public class TechnicController {
    private TasksService tasksService;

    public TechnicController(TasksService tasksService){this.tasksService =tasksService;}
    @GetMapping("")
    public String ListTasks(Model model){
        model.addAttribute("technic", tasksService.getAllTasks());
        return "technic";
    }
//    @GetMapping("/instruction/{id}")
//    public String InstructionTask(@PathVariable Long id, Model model){
//        model.addAttribute("technic", tasksService.getTaskById(id));
//        return "instruction";
//    }

}
