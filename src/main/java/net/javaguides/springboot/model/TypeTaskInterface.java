package net.javaguides.springboot.model;

public interface TypeTaskInterface<T>{
    TypeTask getTypeTask();
    void doSomething(T object);


}
