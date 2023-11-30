package Controllers;

import java.util.ArrayList;
import java.util.Optional;

import Domain.Student.Address;
import Domain.Student.Name;
import Domain.Student.Student;
import Domain.Student.StudentInfo;
import QueryParameters.QueryParameters;
import Repositories.Repository;

import Domain.Student.Country;
import Domain.Student.Day;
import Domain.Student.Month;

public class StudentController {
    // TODO Make this the concrete student type
    private Repository<Student> repository;

    public StudentController(Repository<Student> repository) {
        this.repository = repository;
    }

    // TODO Use `QueryParams`
    public Optional<Student> fetchById(QueryParameters params) {
        return this.repository.fetchById(params.get("id"));
    }

    public ArrayList<Student> fetchMany() {
        return this.repository.fetchMany();
    }

    public void create(QueryParameters params) {
        Name name = new Name(params.get("firstName"), params.get("middleName"), params.get("lastName"));

        Address address = new Address(Integer.parseInt(params.get("streetNumber")), params.get("addressLineOne"),
                params.get("addressLineTwo"), params.get("cityName"), Country.Canada, params.get("postalCode"));

        Day birthdate = new Day(Month.April, 1, 2000);

        StudentInfo studentInfo = new StudentInfo(name, address, birthdate);

        Student student = new Student(studentInfo, params.get("id"));

        System.out.println("Creating student: " + student);

        this.repository.create(student);
    }

    public void update(Student updatedStudent) {
        this.repository.update(updatedStudent);
    }
}