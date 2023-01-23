package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Part;

import java.util.List;

public interface PartService {
    List<Part> getAllParts();
    Part savePart(Part part);
    Part getPartById(long id);
    Part updatePart(Part part);
    void deletePartById(long id);
    Part getPart(long id);
}
