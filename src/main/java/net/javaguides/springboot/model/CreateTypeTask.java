package net.javaguides.springboot.model;

import org.springframework.stereotype.Component;

@Component
public class CreateTypeTask<Create> implements TypeTaskInterface<Create>{
    private static final TypeTask TYPE_TASK = TypeTask.create;

    @Override
    public TypeTask getTypeTask() {
        return TYPE_TASK;
    }

    @Override
    public void doSomething(Create object) {
        System.out.println("create object");
    }
}
