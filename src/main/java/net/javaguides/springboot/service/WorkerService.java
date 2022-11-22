package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> getAllWorker();
    Worker saveWorker(Worker worker);
    Worker getWorkerById(long id);
    Worker updateWorker(Worker worker);
    void deleteWorkerById(long id);

}
