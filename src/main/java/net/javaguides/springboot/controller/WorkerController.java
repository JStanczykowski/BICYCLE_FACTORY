package net.javaguides.springboot.controller;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final UserService workerService;

    public WorkerController(UserService workerService){this.workerService =workerService;}

    @GetMapping("")
    public String ListTechnic(Model model){
        Predicate<User> byActive = user -> user.isActive().equals(true);
        List<User> result = workerService.getAllUser().stream().filter(byActive)
                .collect(Collectors.toList());
        model.addAttribute("workers", result);
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
                               @ModelAttribute("workers") User worker
                              ){
        User existingWorker = workerService.getWorkerById(id);
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
        User obj = workerService.getWorkerById(id);
        obj.setActive(false);
        workerService.updateWorker(obj);
        return "redirect:/worker";
    }
    @GetMapping("/reset/{id}")
    public String resetWorker(@PathVariable Long id){
        User obj = workerService.getWorkerById(id);
        obj.setPassword(passwordEncoder.encode("password"));

        workerService.updateWorker(obj);
        return "redirect:/worker";
    }

}

