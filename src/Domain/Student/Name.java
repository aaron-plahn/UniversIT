package Domain.Student;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;

    }

    public String toString() {
        return (firstName + " " + middleName + " " + lastName);
    }

    public boolean isEqual(Name nameToCompare) {
        if (firstNameEqual(nameToCompare) && middleNameEqual(nameToCompare) && lastNameEqual(nameToCompare))
            return true;
        return false;
    }

    public boolean firstNameEqual(Name nameToCompare) {
        if (firstName == nameToCompare.firstName)
            return true;
        return false;
    }

    public boolean lastNameEqual(Name nameToCompare) {
        if (lastName == nameToCompare.lastName)
            return true;
        return false;
    }

    private boolean middleNameEqual(Name nameToCompare) {
        if (middleName == nameToCompare.middleName)
            return true;
        return false;

    }

    public Name updateFirstName(String newFirstName) {
        return new Name(newFirstName, middleName, lastName);
    }

    public Name updateLastName(String newLastName) {
        return new Name(firstName, middleName, newLastName);
    }

    public Name updateMiddleName(String newMiddleName) {
        return new Name(firstName, newMiddleName, lastName);
    }
}
