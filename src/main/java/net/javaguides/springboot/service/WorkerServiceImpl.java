package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Worker;
import net.javaguides.springboot.repository.WorkerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    private WorkerRepo technicRepo;

    public WorkerServiceImpl(WorkerRepo technicRepo) {
        this.technicRepo = technicRepo;
    }
    @Override
    public List<Worker> getAllWorker(){
        return technicRepo.findAll();
    }
    @Override
    public Worker saveWorker(Worker worker){
        return technicRepo.save(worker);
    }
    @Override
    public Worker getWorkerById(long id){
        return technicRepo.findById(id).get();
    }
    @Override
    public Worker updateWorker(Worker worker){
        return technicRepo.save(worker);
    }
    @Override
    public void deleteWorkerById(long id){
        technicRepo.deleteById(id);
    }
}

