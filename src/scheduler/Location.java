package scheduler;


/**
 This class defines constants and properties for the five locations for vaccination appointments. Each constant
 represents a county name and the properties for each constant are the zipcode and city. This class also contains a
 location constructor and returns a string consisting of the city, the zipcode, and the county of the vaccination
 location. There is also a method that returns the zipcode of a location object.
 @author Karan Patel, Azaan Siddiqi
 */
public enum Location {
    SOMERSET("08807", "Bridgewater"),
    MIDDLESEX("08854", "Piscataway"),
    MERCER("08542", "Princeton"),
    MORRIS("07960", "Morristown"),
    UNION("07083", "Union");

    private final String ZIPCODE;
    private final String CITY;


    /**
     Creates a Location object that contains string representations of a zipcode and a city.
     @param zipcode string representation of a zipcode for a vaccination location.
     @param city string representation of the city for a vaccination location.
     */
    Location(String zipcode, String city) {
        this.ZIPCODE = zipcode;
        this.CITY = city;
    }


    /**
     Returns the zipcode of the enum object that it belongs to.
     @return the zipcode associated with the correct county name related to the enum object.
     */
    String getZIPCODE() {
        return this.ZIPCODE;
    }


    /**
     Returns a string representation of the vaccination location containing the city, zipcode, and county name.
     @return A string containing the city, zipcode, and county name of the vaccination location.
     */
    @Override
    public String toString() {
        return this.CITY + " " + this.ZIPCODE + ", " + name();
    }
}