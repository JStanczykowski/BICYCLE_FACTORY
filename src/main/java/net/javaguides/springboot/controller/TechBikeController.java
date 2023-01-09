package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.repository.TasksRepo;
import net.javaguides.springboot.service.BikeService;
import net.javaguides.springboot.service.TasksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TechBikeController {
    private TasksService tasksService;

    private BikeService bikeService;
    private final TasksRepo tasksRepo;

    public TechBikeController(TasksService tasksService,
                             BikeService bikeService,
                              TasksRepo tasksRepo){this.tasksService =tasksService;

        this.bikeService = bikeService;
        this.tasksRepo = tasksRepo;
    }
    @PostMapping("/engineer/bike")
    public String saveTaskk(@ModelAttribute("task") Tasks task ){

        task.setDone(false);
      for(int i=0;i<tasksService.getAllTasks().size();i++) {
          if(tasksService.getAllTasks().get(i).getDone()==null){
             task.setOrderNumber(tasksService.getAllTasks().get(i).getOrderNumber());
             tasksRepo.delete(tasksService.getAllTasks().get(i));
          }
      }
        tasksService.updateTask(task);
        return "redirect:/engineer/bike";
    }
    @GetMapping("/engineer/bike/{id}")
    public String createTask(Model model, @PathVariable Long id){
        Tasks task = new Tasks();

        task.setOrderNumber(Math.toIntExact(id));
        tasksService.save(task);
        Bike bike= bikeService.getBike(id);
        bike.setActive(false);
        bikeService.updateBike(bike);
        model.addAttribute("task",task.getOrderNumber());
        model.addAttribute("task",task);
        return "add_bike";
    }
}
