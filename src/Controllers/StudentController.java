package Controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.processing.Generated;

import Domain.Grade.CourseOutcome;
import Domain.Grade.Grade;
import Domain.Grade.Transcript;
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

    public Transcript getTranscript(QueryParameters params) {
        Optional<Student> searchResult = fetchById(params);

        if (!searchResult.isPresent()) {
            // empty transcript
            return new Transcript(new CourseOutcome[0]);
        }

        Student student = searchResult.get();

        int numberOfOutcomes = student.getCourseOutcomes().size();

        CourseOutcome[] courseOutcomes = new CourseOutcome[numberOfOutcomes];

        for (int i = 0; i < numberOfOutcomes; i++) {
            courseOutcomes[i] = student.getCourseOutcomes().get(i);
        }

        return new Transcript(courseOutcomes);
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

    public void recordGrade(QueryParameters params) {
        String studentId = params.get("studentId");

        Optional<Student> studentSearchResult = this.repository.fetchById(studentId);

        if (!studentSearchResult.isPresent()) {
            System.out.println("student not found: " + studentId);
            return;
        }

        Student student = studentSearchResult.get();

        CourseOutcome courseOutcome = new CourseOutcome(params.get("semester"), params.get("courseId"),
                parseGrade(params.get("grade")));

        student.recordCourseOutcome(courseOutcome);

        this.repository.update(student);

        System.out.println("Recorded course outcome: " + courseOutcome + "for student: " + student);
    }

    private Grade parseGrade(String input) {
        if (input.equalsIgnoreCase("A"))
            return Grade.A;

        if (input.equalsIgnoreCase("B"))
            return Grade.B;

        if (input.equalsIgnoreCase("C"))
            return Grade.C;

        if (input.equalsIgnoreCase("D"))
            return Grade.D;

        return Grade.F;
    }
}