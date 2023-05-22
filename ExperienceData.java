import java.util.ArrayList;

public class ExperienceData implements Comparable<ExperienceData> {
    private String companyName;
    private LocationData companyLocation;
    private String jobTitle;
    private DateData startDate;
    private DateData endDate;
    private ArrayList<String> responsibility;

    public ExperienceData(String companyName, LocationData companyLocation, String jobTitle, DateData startDate, DateData endDate, ArrayList<String> responsibility) {
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.jobTitle = jobTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.responsibility = responsibility;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocationData getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(LocationData companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public DateData getStartDate() {
        return startDate;
    }

    public void setStartDate(DateData startDate) {
        this.startDate = startDate;
    }

    public DateData getEndDate() {
        return endDate;
    }

    public void setEndDate(DateData endDate) {
        this.endDate = endDate;
    }

    public ArrayList<String> getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(ArrayList<String> responsibility) {
        this.responsibility = responsibility;
    }

    public String toString() {
        String responString = "";
        for (String item: responsibility) {
            responString = responString + "\n\t- " + item;
        }
        return companyName + ", " + companyLocation + "\n" + jobTitle
                + " / " + startDate + " - " + endDate + responString;
    }

    /**
     * compares the endDate
     * @param e the object to be compared.
     * @return the int difference in year/month
     */
    public int compareTo(ExperienceData e) {
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