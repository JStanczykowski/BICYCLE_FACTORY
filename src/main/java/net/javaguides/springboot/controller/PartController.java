package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.Part;
import net.javaguides.springboot.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/part")
public class PartController {
    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }
    @GetMapping("")
    public List<Part> getParts() {
        return partService.getAllParts();
    }
    @PostMapping("/add")
    public void addBike(@RequestBody Part part) {
        partService.savePart(part);
    }

}
