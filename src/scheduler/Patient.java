package scheduler;


/**
 This class compares a patient object to another patient object, and it also returns a string representation of an
 individual's first name, last name, and date of birth. There is a constructor for a patient object as well as a
 method that returns the date of birth of a patient object.
 @author Karan Patel, Azaan Siddiqi
 */
public class Patient implements Comparable<Patient> {
    private String fname;
    private String lname;
    private Date dob;


    /**
     Creates a patient object consisting of the first name, last name, and date of birth of the patient.
     @param first a string representation of the first name of the patient.
     @param last a string representation of the last name of the patient.
     @param birth a Date object containing the date of birth of the patient.
     */
    public Patient(String first, String last, Date birth) {
        this.fname = first;
        this.lname = last;
        this.dob = birth;
    }


    /**
     Returns the Date object, specifically the date of birth, associated with the Patient object.
     @return the Date object, which is the date of birth, associated with the Patient object.
     */
    public Date getDob() {
        return this.dob;
    }


    /**
     Returns the first name, last name, and date of birth of a patient.
     @return A String that details a patient's first name, last name, and date of birth.
     */
    @Override
    public String toString() {
        return fname + " " + lname + ", DOB: " + dob.toString();
    }


    /**
     Compares a patient object to another patient object by first comparing their last names, then their
     first names, and then their dates of birth.
     @param patient the patient object to be compared to another patient object.
     @return -1 if the first patient's last name, first name, or date of birth, in that order, comes before the second
     patient. 1 if the first patient's last name, first name, or date of birth, in that order, comes after the second
     patient. 0 if both patients have the same name and date of birth.
     */
    @Override
    public int compareTo(Patient patient) {
        if (lname.compareTo(patient.lname) < 0) {
            return -1;
        }
        else if (lname.compareTo(patient.lname) > 0) {
            return 1;
        }
        else if (fname.compareTo(patient.fname) < 0) {
            return -1;
        }
        else if (fname.compareTo(patient.fname) > 0) {
            return 1;
        }
        else if (dob.compareTo(patient.dob) < 0) {
            return -1;
        }
        else if (dob.compareTo(patient.dob) > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}