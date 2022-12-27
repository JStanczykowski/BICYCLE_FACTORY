package net.javaguides.springboot.task;

import net.javaguides.springboot.Component.Create;
import net.javaguides.springboot.Component.TypeTaskFactory;
import net.javaguides.springboot.model.CreateTypeTask;
import net.javaguides.springboot.model.TypeTask;
import net.javaguides.springboot.repository.TasksRepo;
import net.javaguides.springboot.service.TasksServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class TaskTest {
    @Autowired
    public TasksRepo tasksRepo;
    @Autowired
    public TypeTaskFactory typeTaskFactory;

    @Autowired
    public TasksServiceImpl tasksServiceImpl;

    @BeforeEach
    void setup() {
        tasksRepo = mock(TasksRepo.class);
        tasksServiceImpl = mock(TasksServiceImpl.class);
        typeTaskFactory = new CreateTypeTask<Create>();
    }

    @Test
    void addCreateTask() {
        CreateTypeTask createTypeTask = typeTaskFactory.ge
    }
}
