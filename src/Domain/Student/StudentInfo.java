package Domain.Student;

public class StudentInfo {
    private Name studentName;
    private Address studentAddress;
    private Day dateOfBirth;
    private int yearStanding;

    public StudentInfo(Name nameOfStudent, Address address, Day dateOfBirth) {
        this.studentName = nameOfStudent;
        this.studentAddress = address;
        this.dateOfBirth = dateOfBirth;
        this.yearStanding = 0;
    }

    public Name getName() {
        return studentName;
    }

    public Address getAddress() {
        return studentAddress;
    }

    public Day getDateOfBirth() {
        return dateOfBirth;
    }

    public int getYearStanding() {
        return yearStanding;
    }

    public void updateYearStanding() {
        yearStanding++;
    }

    public void updateYearStanding(int newYearStanding) {
        yearStanding = newYearStanding;
    }

    public String toString() {
        return studentName + " was born on " + dateOfBirth + " lives at " + studentAddress
                + " and has been at the school for " + yearStanding + " years";
    }

}
