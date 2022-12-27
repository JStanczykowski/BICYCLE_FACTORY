package net.javaguides.springboot.service;


import net.javaguides.springboot.model.Part;
import net.javaguides.springboot.repository.BikeRepository;
import net.javaguides.springboot.repository.PartRepository;
import net.javaguides.springboot.repository.TasksRepo;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PartServiceImpl implements PartService {
    @Autowired
    private PartRepository partRepository;


    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        super();
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    @Override
    public Part savePart(Part part) {
        return partRepository.save(part);
    }

    @Override
    public Part getPartById(long id) {
        return partRepository.findById(id).get();
    }

    @Override
    public Part updatePart(Part part) {
        return partRepository.save(part);
    }

    @Override
    public void deletePartById(long id) {
        partRepository.deleteById(id);
    }

    @Override
    public Part getPart(long id) {
        Optional<Part> partOptional = partRepository.findById(id);
        return partOptional.get();
    }
}
