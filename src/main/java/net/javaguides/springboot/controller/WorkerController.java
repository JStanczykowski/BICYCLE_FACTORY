package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.Worker;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.service.WorkerService;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    private UserService workerService;
    private UserRepository userRepository;
    public WorkerController(UserService workerService){this.workerService =workerService;}

    @GetMapping("")
    public String ListTechnic(Model model){
        model.addAttribute("workers", workerService.getAllUser());
        return "worker";
    }
    @GetMapping("/new")
    public String createWorker(Model model){
        User worker = new User();
        model.addAttribute("workers",worker);
        return "add_worker";
    }
    @PostMapping("")
    public String saveWorker(@ModelAttribute("workers") UserRegistrationDto worker){
        workerService.saveWorker(worker);
        return "redirect:/worker";
    }
    @GetMapping("/edit/{id}")
    public String editWorkerForm(@PathVariable Long id, Model model){

        model.addAttribute("workers", workerService.getWorkerById(id));
        return "edit_worker";
    }
    @PostMapping("/{id}")
    public String updateWorker(@PathVariable Long id,
                               @ModelAttribute("workers") User worker,
                               Model model){

        User existingWorker = workerService.getWorkerById(id);
        //existingWorker.setId(id);
        existingWorker.setFirstName(worker.getLastName());
        existingWorker.setLastName(worker.getLastName());
        existingWorker.setEmail(worker.getEmail());
        existingWorker.setPassword(worker.getPassword());
        existingWorker.setRoles(worker.getRoles());
        workerService.deleteWorkerById(id);

        workerService.updateWorker(existingWorker);
        return "redirect:/worker";
    }
    @GetMapping("/{id}")
    public String deleteWorker(@PathVariable Long id){
        workerService.deleteWorkerById(id);
        return "redirect:/worker";
    }

}

