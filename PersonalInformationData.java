public class PersonalInformationData {
    private String fullName;
    private String email;
    private String phoneNumber;
    private LocationData residency;
    private String linkProfile;

    public PersonalInformationData(String fullName, String email, String phoneNumber, LocationData residency, String linkProfile) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.residency = residency;
        this.linkProfile = linkProfile;
    }

    //SETTERS
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setResidency(LocationData residency) {
        this.residency = residency;
    }
    public void setLinkProfile(String linkProfile) {
        this.linkProfile = linkProfile;
    }

    //GETTERS
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public LocationData getResidency() {
        return residency;
    }
    public String getLinkProfile() {
        return linkProfile;
    }

    public String toString() {
        return   fullName + "\n" + email + " | " + phoneNumber + " | "
                + linkProfile + " | " + residency;
    }
}

