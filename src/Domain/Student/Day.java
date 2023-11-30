package Domain.Student;

public class Day {
    int day;
    int year;
    Month month;

    public Day(Month month, int day, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        checkForValidDate();

    }

    public String toString() {
        return "" + month + " " + day + " " + year;
    }

    public Day changeDay(int newDay) {
        return new Day(month, newDay, year);
    }

    public Day changeMonth(Month newMonth) {
        return new Day(newMonth, day, year);
    }

    public Day changeYear(int newYear) {
        return new Day(month, day, newYear);
    }

    public boolean isEqual(Day dateToCompare) {
        return this.toString().equalsIgnoreCase(dateToCompare.toString());
    }

    private void checkForValidDate() {
        int maxDayInMonth = 0;
        switch (month) {
            case January:
                maxDayInMonth = 31;
                break;
            case February:
                if (isLeapyear())
                    maxDayInMonth = 29;
                else
                    maxDayInMonth = 28;
                break;
            case March:
                maxDayInMonth = 31;
                break;
            case April:
                maxDayInMonth = 30;
                break;
            case May:
                maxDayInMonth = 31;
                break;
            case June:
                maxDayInMonth = 30;
                break;
            case July:
                maxDayInMonth = 31;
                break;
            case August:
                maxDayInMonth = 31;
                break;
            case September:
                maxDayInMonth = 30;
                break;
            case October:
                maxDayInMonth = 31;
                break;
            case November:
                maxDayInMonth = 30;
                break;
            case December:
                maxDayInMonth = 31;
                break;
            default:
                break;
        }
        if (day > maxDayInMonth)
            day = maxDayInMonth;
    }

    private boolean isLeapyear() {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }

}
