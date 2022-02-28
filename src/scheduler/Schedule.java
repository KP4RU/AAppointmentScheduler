package scheduler;


/**
 Contains and maintains the list of appointments as well as the number of appointments across the 5 vaccination
 locations. Within this class, one may find an appointment, increase size of the appointments array, add an appointment,
 remove an appointment, and print appointments in three different ways. There is also a non-parameterized constructor
 for a schedule object and getter methods for retrieving the information held by instance variables.
 @author Karan Patel, Azaan Siddiqi
 */
public class Schedule {
    private Appointment [] appointments;
    private int numAppts;

    public static final int NOT_FOUND = -1;
    public static final int INCREASE_ARRAY_CAPACITY = 4;


    /**
     Creates a schedule object by instantiating an array for appointments and setting the number of current appointments
     to zero.
     */
    public Schedule() {
        this.appointments = new Appointment[INCREASE_ARRAY_CAPACITY];
        this.numAppts = 0;
    }


    /**
     Returns the appointments array that contains a list of all the appointments across the 5 vaccination
     locations.
     @return the appointments array that contains all the valid appointments.
     */
    public Appointment [] getAppointments() {
        return this.appointments;
    }


    /**
     Returns the number of appointments across the 5 vaccination locations.
     @return the number of valid appointments.
     */
    public int getnumAppts() {
        return this.numAppts;
    }


    /**
     Takes an appointment and checks if it is inside the appointments array in order to confirm that it is
     an actual appointment.
     @param appt the appointment to be searched for inside the appointments array.
     @return the index of the appointment if it is found inside the appointments array, -1 (NOT_FOUND) otherwise.
     */
    private int find(Appointment appt) {
        for (int i = 0; i < numAppts; i++) {
            if (appointments[i].equals(appt) == true) {
                return i;
            }
        }
        return NOT_FOUND;
    } //return the index, or NOT_FOUND


    /**
     Increases the size of the appointments array by 4. This allows for more space in the array for more
     appointments to be added to it.
     */
    private void grow() {
        Appointment[] increasedSize = new Appointment[appointments.length + INCREASE_ARRAY_CAPACITY];
        for (int i = 0; i < appointments.length; i++) {
            increasedSize[i] = appointments[i];
        }
        appointments = increasedSize;
    }//increase the capacity of the container by 4


    /**
     Adds an appointment to the appointments array. Before it does this, it checks if the appointments array is full
     and calls the "grow" method to increase the size of the array by 4 if it is.
     @param appt the appointment to be added to the appointments array.
     @return true if the appointment was successfully added.
     */
    public boolean add(Appointment appt) {
        if (numAppts == appointments.length) {
            grow();
        }
        appointments[numAppts] = appt;
        numAppts++;
        return true;
    }


    /**
     Removes an appointment from the appointments array if the appointment to be removed is inside the array. It checks
     for this by calling the "find" method.
     @param appt the appointment to be removed from the appointments array.
     @return true if the appointment was successfully removed from the appointments array, false if the appointment
     was never in the array.
     */
    public boolean remove(Appointment appt) {
        int removedApptIndex = find(appt);
        if (removedApptIndex == NOT_FOUND) {
            return false;
        } else {
            for (int j = removedApptIndex + 1; j < numAppts; j++) {
                appointments[j - 1] = appointments[j];
            }
            appointments[numAppts - 1] = null;
            numAppts--;
            return true;
        }
    }


    /**
     Prints all the appointments in the appointments array by the order given. For each appointment, it prints the
     patient information, the appointment details, and the vaccination location.
     */
    public void print() {
        for (int i = 0; i < numAppts; i++) {
            System.out.println(appointments[i].toString());
        }
    } //print all the appointments in current order


    /**
     Prints all the appointments in the appointments array in the order of the lowest zipcode to the highest zipcode.
     For each appointment, it prints the patient information, the appointment details, and the vaccination location.
     */
    public void printByZip() {
        for (int i = 1; i < numAppts; i++) {
            Appointment saveAppt = appointments[i];
            int j = i - 1;
            while (j >= 0 && appointments[j].getLocation().getZIPCODE().compareTo(saveAppt.getLocation().getZIPCODE())
                    >= 0) {
                if (appointments[j].getLocation().getZIPCODE().compareTo(saveAppt.getLocation().getZIPCODE()) == 0) {
                    if (appointments[j].getTimeslot().compareTo(saveAppt.getTimeslot()) > 0) {
                        appointments[j + 1] = appointments[j];
                        j = j - 1;
                    } else {
                        break;
                    }
                } else {
                    appointments[j + 1] = appointments[j];
                    j = j - 1;
                }
            }
            appointments[j + 1] = saveAppt;
        }
        print();
    } //sort by zip codes and print


    /**
     Prints all the appointments in the appointments array in the order of the patients' last names, then first names,
     and then dates of birth. For each appointment, it prints the patient information, the appointment details,
     and the vaccination location.
     */
    public void printByPatient() {
        for (int i = 1; i < numAppts; i++) {
            Appointment saveAppt = appointments[i];
            int j = i - 1;
            while (j >= 0 && appointments[j].getPatient().compareTo(saveAppt.getPatient()) > 0) {
                appointments[j + 1] = appointments[j];
                j = j - 1;
            }
            appointments[j + 1] = saveAppt;
        }
        print();
    } //sort by patient and print
}
