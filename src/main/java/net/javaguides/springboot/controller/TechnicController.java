package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.model.TypeTask;
import net.javaguides.springboot.repository.TasksRepo;
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
    private final TasksRepo tasksRepo;

    public TechnicController(TasksService tasksService,
                             TasksRepo tasksRepo){this.tasksService =tasksService;
        this.tasksRepo = tasksRepo;
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
    @PostMapping("/engineer/bike")
    public String saveCars(@ModelAttribute("task") Tasks task ){
        tasksService.save(task);
        return "redirect:/engineer/bike";
    }
    @GetMapping("/engineer/bike/{id}")
    public String createTask(Model model,@PathVariable Long id){
        Tasks task = new Tasks();
        Tasks task1 = tasksService.getTaskById(id);
        task.setTime(task1.getTime());
        model.addAttribute("task",task);
        return "add_bike";
    }
}
