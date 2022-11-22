package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Worker;
import net.javaguides.springboot.service.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    private WorkerService workerService;

    public WorkerController(WorkerService workerService){this.workerService =workerService;}
    @GetMapping("")
    public String ListTechnic(Model model){
        model.addAttribute("workers", workerService.getAllWorker());
        return "worker";
    }
    @GetMapping("/new")
    public String createWorker(Model model){
        Worker worker = new Worker();
        model.addAttribute("workers",worker);
        return "add_worker";
    }
    @PostMapping("")
    public String saveWorker(@ModelAttribute("workers") Worker worker){
        workerService.saveWorker(worker);
        return "redirect:/worker";
    }
    @GetMapping("/edit/{id}")
    public String editWorkerForm(@PathVariable Long id, Model model){
        model.addAttribute("workers", workerService.getWorkerById(id));
        return "edit_worker";
    }
    @PostMapping("/{id}")
    public String updateWorker(@PathVariable Long id, @ModelAttribute("workers") Worker worker, Model model){
        Worker existingWorker = workerService.getWorkerById(id);
        existingWorker.setId(id);
        existingWorker.setFirstName(worker.getLastName());
        existingWorker.setLastName(worker.getLastName());
        existingWorker.setRole(worker.getRole());

        workerService.updateWorker(existingWorker);
        return "redirect:/worker";
    }
    @GetMapping("/{id}")
    public String deleteWorker(@PathVariable Long id){
        workerService.deleteWorkerById(id);
        return "redirect:/";
    }

}

