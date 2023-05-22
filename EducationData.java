public class EducationData implements Comparable<EducationData> {
    private String institution;
    private LocationData schoolLocation;
    private String typeOfDegree;
    private String major;
    private DateData gradDate;
    private String courseWork;
    private double GPA;

    public EducationData(String institution, LocationData schoolLocation, String typeOfDegree, String major, DateData gradDate, String courseWork, double GPA) {
        this.institution = institution;
        this.schoolLocation = schoolLocation;
        this.typeOfDegree = typeOfDegree;
        this.major = major;
        this.gradDate = gradDate;
        this.courseWork = courseWork;
        this.GPA = GPA;
    }


    //SETTERS
    public void setInstitution(String institution) {
        this.institution = institution;
    }
    public void setSchoolLocation(LocationData schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    public void setTypeOfDegree(String typeOfDegree) {
        this.typeOfDegree = typeOfDegree;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setGradDate(DateData gradDate) {
        this.gradDate = gradDate;
    }
    public void setCourseWork(String courseWork) {
        this.courseWork = courseWork;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    //GETTERS
    public String getInstitution() {
        return institution;
    }
    public LocationData getSchoolLocation() {
        return schoolLocation;
    }
    public String getTypeOfDegree() {
        return typeOfDegree;
    }
    public String getMajor() {
        return major;
    }
    public DateData getGradDate() {
        return gradDate;
    }
    public String getCourseWork() {
        return courseWork;
    }
    public double getGPA() {
        return GPA;
    }

    public String toString() {
        return institution + ", " + schoolLocation + "\n\t" +
                typeOfDegree + " / " + major + " / " + GPA + " GPA / Graduation Date: "
                + gradDate + "\n\tRelevant Coursework: " + courseWork;
    }

    /**
     * compares the gradDate
     * @param e the object to be compared.
     * @return the int difference in years/months
     */
    public int compareTo(EducationData e) {
        int yearDif = this.gradDate.getYear() - e.getGradDate().getYear();
        if (yearDif == 0) {
            return this.gradDate.getMonth() - e.getGradDate().getMonth();
        } else {
            return yearDif;
        }

        // positive = this is more recent
        // 0 = same year
        // negative = e is more recent
    }
}
