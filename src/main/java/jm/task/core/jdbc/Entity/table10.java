package jm.task.core.jdbc.Entity;

import javax.persistence.*;

@Entity

public class table10 {
    public table10(Long id, String name, String lastName, Byte age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Byte age;

    public table10() {

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private Long getId() {
        return id;
    }
}
