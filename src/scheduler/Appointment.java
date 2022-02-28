package scheduler;


/**
 This class takes an Appointment object and either compares it to another Appointment object, or returns a string
 that contains the name of the patient, the date of birth of the patient, and their appointment details. This class
 also contains a constructor for an appointment object as well as getter methods for retrieving the information held by
 instance variables.
 @author Karan Patel, Azaan Siddiqi
 */
public class Appointment {
    private Patient patient;
    private Timeslot slot;
    private Location location;


    /**
     Creates an appointment object consisting of Patient, Timeslot, and Location objects.
     @param patient Patient object containing the first and last name and date of birth of the patient.
     @param slot Timeslot object containing the date and time of the appointment.
     @param location Location object containing the zipcode and city of the vaccination location.
     */
    public Appointment(Patient patient, Timeslot slot, Location location) {
        this.patient = patient;
        this.slot = slot;
        this.location = location;
    }


    /**
     Compares the patient, timeslot, and location objects of two appointment objects.
     @param obj the specified appointment object to be compared to the original appointment object.
     @return true if the patient, timeslot, and location objects of both appointment objects are equal.
     false if they aren't equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Appointment) {
            Appointment secondAppt = (Appointment) obj;
            if (patient.compareTo(secondAppt.patient) == 0 && slot.compareTo(secondAppt.slot) == 0 &&
                    location.equals(secondAppt.location)) {
                return true;
            }
        }
        return false;
    }


    /**
     Returns the patient object associated with the appointment object.
     @return the patient object associated with the given appointment object.
     */
    public Patient getPatient() {
        return this.patient;
    }


    /**
     Returns the timeslot object associated with the appointment object.
     @return the timeslot object associated with the given appointment object.
     */
    public Timeslot getTimeslot() {
        return this.slot;
    }


    /**
     Returns the location object associated with the appointment object.
     @return the location object associated with the given appointment object.
     */
    public Location getLocation() {
        return this.location;
    }


    /**
     Converts the name of the patient, the date of birth of the patient, and their appointment details
     as a string and returns it.
     @return A string consisting of the name of the patient, the date of birth of the patient,
     and their appointment details.
     */
    @Override
    public String toString() {
        return patient.toString() + ", " + "Appointment detail: " + slot.toString() + ", " + location.toString();
    }
}
