package net.javaguides.springboot.task;

import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.repository.TasksRepo;
import net.javaguides.springboot.service.TasksService;
import net.javaguides.springboot.service.TasksServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class TaskTest {
    @Autowired
    public TasksRepo tasksRepo;
    @Autowired
    public TasksServiceImpl tasksServiceImpl;
    @Autowired
    public TasksService tasksService;


    @BeforeEach
    void setup() {
        tasksRepo = mock(TasksRepo.class);
        tasksServiceImpl = mock(TasksServiceImpl.class);
    }

    @Test
    void addTask() {
        Tasks tasks = new Tasks.TaskEntityBuilder().
                setOrderNumber(3).
                setInstruction("instrukcja").
                setDone(true).
                build();
        tasksService.save(tasks);
        tasksServiceImpl.save(tasks);

        List<Tasks> all = tasksRepo.findAll();

        assertThat(all.contains(tasks));
    }


    @Test
    void removeTask() {
        Tasks tasks = new Tasks.TaskEntityBuilder().
                setOrderNumber(3).
                setInstruction("instrukcja").
                setTime("2 days").
                build();

        tasksService.save(tasks);
        tasksServiceImpl.deleteTaskById(1);

        List<Tasks> all = tasksRepo.findAll();
        assertThat(all.contains(tasks));
    }

}
