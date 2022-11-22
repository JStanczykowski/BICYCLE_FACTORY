package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "Worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    @Enumerated(EnumType.ORDINAL)
    private Worker_Role role;
    public Worker() {
    }

    public void setRole(Worker_Role role) {
        this.role = role;
    }

    public Worker_Role getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Technic{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Worker(String firstName, String lastName, Worker_Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}

