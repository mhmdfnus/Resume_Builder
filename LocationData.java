public class LocationData {
    private String state;
    private String city;

    public LocationData(String state, String city) {
        this.state = state;
        this.city = city;
    }

    //SETTERS
    public void setState(String state) {
        this.state = state;
    }
    public void setCity(String city) {
        this.city = city;
    }

    //GETTERS
    public String getState() {
        return state;
    }
    public String getCity() {
        return city;
    }

    public String toString() {
        return city + ", " + state;
    }
}
