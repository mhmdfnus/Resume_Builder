import java.util.ArrayList;

public class ProjectData implements Comparable <ProjectData> {
    private String name;
    private ArrayList<String> description;
    private DateData startDate;
    private DateData endDate;

    public ProjectData(String name, ArrayList<String> description, DateData startDate, DateData endDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //GETTERS
    public String getName() {
        return name;
    }
    public ArrayList<String> getDescription() {
        return description;
    }
    public DateData getStartDate() {
        return startDate;
    }
    public DateData getEndDate() {
        return endDate;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }
    public void setStartDate(DateData startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(DateData endDate) {
        this.endDate = endDate;
    }

    public String toString() {
        String descriptString = "";
        for (String item: description) {
            descriptString = descriptString + "\n\t" + item;
        }
        return name + ", " + startDate + " - " + endDate + descriptString;
    }

    /**
     * compares the endDate
     * @param e the object to be compared.
     * @return the int difference in year/month
     */
    public int compareTo(ProjectData e) {
        int yearDif = this.endDate.getYear() - e.getEndDate().getYear();
        if (yearDif == 0) {
            return this.endDate.getMonth() - e.getEndDate().getMonth();
        } else {
            return yearDif;
        }

        // positive = this is more recent
        // 0 = same year
        // negative = e is more recent
    }

}
