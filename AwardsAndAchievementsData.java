public class AwardsAndAchievementsData implements Comparable<AwardsAndAchievementsData> {
    private String award;
    private DateData dateAwarded;

    public AwardsAndAchievementsData(String award, DateData dateAwarded) {
        this.award = award;
        this.dateAwarded = dateAwarded;
    }

    // setters and getters
    public String getAward() {
        return award;
    }
    public DateData getDateAwarded() {
        return dateAwarded;
    }
    public void setAward(String award) {
        this.award = award;
    }
    public void setDateAwarded(DateData dateAwarded) {
        this.dateAwarded = dateAwarded;
    }

    // toString
    public String toString() {
        return award + " - " + dateAwarded;
    }

    /**
     * compares the dateAwarded
     * @param e the object to be compared.
     * @return
     */
    public int compareTo(AwardsAndAchievementsData e) {
        int yearDif = this.dateAwarded.getYear() - e.getDateAwarded().getYear();
        if (yearDif == 0) {
            return this.dateAwarded.getMonth() - e.getDateAwarded().getMonth();
        } else {
            return yearDif;
        }

        // positive = this is more recent
        // 0 = same year
        // negative = e is more recent
    }
}