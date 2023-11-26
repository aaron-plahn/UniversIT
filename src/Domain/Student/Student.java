package Domain.Student;

import Repositories.Entity;

public class Student implements Entity {
    private String name;

    private String id;

    private int year;

    public Student(String name, String id) {
        this.name = name;

        this.id = id;

        this.year = 0;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "Hi, my name is: " + name + ", and I am in year: " + year;
    }

    public Student promote() {
        this.year++;

        return this;
    }
}
