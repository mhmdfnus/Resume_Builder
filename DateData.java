public class DateData {
    private int month;
    private int year;

    public DateData(int month, int year) {
        this.month = month;
        this.year = year;
    }

    // setters and getters
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public String toString() {
        return month + "-" + year;
    }
}
