package net.javaguides.springboot.service;

import net.javaguides.springboot.Component.Create;
import net.javaguides.springboot.Component.TypeTaskFactory;
import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.model.TypeTask;
import net.javaguides.springboot.repository.TasksRepo;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TasksServiceImpl implements TasksService{
    @Autowired
    private TasksRepo tasksRepo;

    private final TypeTaskFactory typeTaskFactory;
    @Autowired
    public TasksServiceImpl(TasksRepo tasksRepo, TypeTaskFactory typeTaskFactory) {
        super();
        this.tasksRepo = tasksRepo;
        this.typeTaskFactory = typeTaskFactory;
    }
    @Override
    public Tasks save(UserRegistrationDto registrationDto) {
        return null;
    }

    @Override
    public List<Tasks> getAllTasks() {
        return tasksRepo.findAll();
    }
    @Override
    public Tasks getTaskById(long id){
        return tasksRepo.findById(id).get();
    }
    @Override
    public Tasks updateTask(Tasks tasks){
        return tasksRepo.save(tasks);
    }
    @Override
    public void deleteTaskById(long id){
        tasksRepo.deleteById(id);
    }
    @Override
    public void doSomething(TypeTask typeTask, Object o) {
        typeTaskFactory.getType(typeTask).doSomething(o);
    }

    @PostConstruct
    public void test() {
        doSomething(TypeTask.create, new Create());
    }

}
