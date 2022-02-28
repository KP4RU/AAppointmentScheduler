package scheduler;
import java.util.Scanner;


/**
 This class contains and modifies a schedule object based on the commands and information obtained from standard input.
 These commands may request to add an appointment, which may be done after checking that the appointment is valid. These
 commands may also request to remove an appointment(s), and print all the appointments in various ways. There is also
 a Kiosk constructor for initializing a schedule object.
 @author Karan Patel, Azaan Siddiqi
 */
public class Kiosk {

    private Schedule allAppts;


    /**
     Constructor for a kiosk object that instantiates a schedule object. This schedule object will keep track of all the
     appointments across all 5 vaccination locations.
     */
    public Kiosk() {
        this.allAppts = new Schedule();
    }


    /**
     Checks if an appointment is valid by checking if the dates are not valid calendar dates, if the date of birth is
     today or a future date, if the appointment date is today or a date before today or a date beyond this year, and if
     the time is not a fifteen-minute interval and outside the allowed appointment hours.
     @param toAdd the appointment that will be tested to see if it is valid or not.
     @return true if the appointment is valid so far, false if it is not.
     */
    private boolean ValidApptChecker(Appointment toAdd) {
        Date today = new Date();
        Date firstDayOfNextYear = new Date("01/01/2023");
        boolean check = false;
        if (toAdd.getPatient().getDob().isValid() == false) {
            System.out.println("Invalid date of birth!");
        } else if (toAdd.getTimeslot().getDate().isValid() == false) {
            System.out.println("Invalid appointment date!");
        } else if (toAdd.getPatient().getDob().compareTo(today) >= 0) {
            System.out.println("Date of birth invalid -> it is a future date.");
        } else if (toAdd.getTimeslot().getDate().compareTo(today) <= 0) {
            System.out.println("Appointment date invalid -> must be a future date.");
        } else if (toAdd.getTimeslot().getDate().compareTo(firstDayOfNextYear) >= 0) {
            System.out.println("Invalid appointment date!");
        } else if (toAdd.getTimeslot().getTime().isValid() == false) {
            System.out.println("Invalid appointment time! Must enter a time between 9:00 and 16:45 with a " +
                    "15-minute interval.");
        } else {
            check = true;
        }
        return check;
    }


    /**
     Checks if an appointment is valid by checking if an appointment with the same patient, timeslot, and location is
     already in the schedule, if the given timeslot at the given location is already taken, and if an individual is
     booking an appointment with the same patient and date but a different location with an existing appointment.
     @param toAdd the appointment that will be checked to see if it is valid or not.
     @return true if the appointment is valid, false if it is not.
     */
    private boolean ValidApptChecker2(Appointment toAdd) {
        for (int i = 0; i < allAppts.getnumAppts(); i++) {
            if (toAdd.equals(allAppts.getAppointments()[i]) == true) {
                System.out.println("Same appointment exists in the schedule.");
                return false;
            } else if (toAdd.getTimeslot().compareTo(allAppts.getAppointments()[i].getTimeslot()) == 0 &&
                    toAdd.getLocation() == allAppts.getAppointments()[i].getLocation()) {
                System.out.println("Time slot has been taken at this location.");
                return false;
            } else if (toAdd.getPatient().compareTo(allAppts.getAppointments()[i].getPatient()) == 0 &&
                    toAdd.getTimeslot().getDate().compareTo(allAppts.getAppointments()[i].getTimeslot().getDate())
                            == 0 && toAdd.getLocation() != allAppts.getAppointments()[i].getLocation()) {
                System.out.println("Same patient cannot book an appointment with the same date.");
                return false;
            }
        }
        return true;
    }


    /**
     Adds a valid appointment to the schedule object.
     @param toAdd the appointment to be added to the schedule object.
     */
    private void addAppointmentToSchedule(Appointment toAdd) {
        allAppts.add(toAdd);
        System.out.println("Appointment booked and added to the schedule.");
    }


    /**
     Removes an appointment from the schedule object if it is in the schedule, and displays a message afterwards. If the
     appointment is not in the schedule object, then it displays an error message.
     @param toRemove the appointment to be removed from the schedule object.
     */
    private void removeSingleAppointment(Appointment toRemove) {
        boolean check = allAppts.remove(toRemove);
        if (check == false) {
            System.out.println("Not cancelled, appointment does not exist.");
        } else {
            System.out.println("Appointment cancelled.");
        }
    }


    /**
     Attempts to cancel and remove all appointments with the same patient information as the given patient object.
     If successful, it displays a message stating that the appointments have been cancelled. If failed, it displays
     an error message.
     @param toRemove the patient that is cancelling all the appointments with the same patient information.
     */
    private void removeAllAppointments(Patient toRemove) {
        boolean check = false;
        for (int i = 0; i < allAppts.getnumAppts(); i++) {
            if (toRemove.compareTo(allAppts.getAppointments()[i].getPatient()) == 0) {
                check = allAppts.remove(allAppts.getAppointments()[i]);
                i = i - 1;
            }
        }
        if (check == false) {
            System.out.println("Not cancelled, appointment does not exist.");
        } else {
            System.out.println("All appointments for " + toRemove.toString() + " have been cancelled.");
        }
    }


    /**
     Takes in patient information, timeslot information, and location information from standard input and attempts to
     create an appointment.
     @param readStandardInput reads in information from standard input to help create the appointment object.
     @return an appointment object if the given location is valid, null if the location is invalid.
     */
    private Appointment AppointmentCreator(Scanner readStandardInput) {
        Date dateOfBirth = new Date(readStandardInput.next());
        Patient patient = new Patient(readStandardInput.next(), readStandardInput.next(), dateOfBirth);
        Timeslot timeslot = new Timeslot(new Date(readStandardInput.next()), new Time(readStandardInput.next()));
        String read = readStandardInput.next().toUpperCase();
        if (read.equals("SOMERSET")) {
            return new Appointment(patient, timeslot, Location.SOMERSET);
        } else if (read.equals("MIDDLESEX")) {
            return new Appointment(patient, timeslot, Location.MIDDLESEX);
        } else if (read.equals("MERCER")) {
            return new Appointment(patient, timeslot, Location.MERCER);
        } else if (read.equals("MORRIS")) {
            return new Appointment(patient, timeslot, Location.MORRIS);
        } else if (read.equals("UNION")) {
            return new Appointment(patient, timeslot, Location.UNION);
        } else {
            System.out.println("Invalid location!");
            return null;
        }
    }


    /**
     Reads in commands and information from standard input, and modifies the schedule object based on these
     instructions. If "B" is read followed by information, it will try to create and add an appointment to the schedule
     object if the information is valid. If "C" or "CP" is read followed by information, it will try to cancel one or
     more appointments related to this information. If "P" is read, it will try to print the appointments in the
     schedule object by the order given. If "PZ" is read, it will try to print by zipcode, and if "PP" is read, it will
     try to print by patient information. If "Q" is read, the program will come to an end.
     */
    public void run() {
        System.out.println("Kiosk running. Ready to process transactions.");
        Scanner readStandardInput = new Scanner(System.in);
        while (readStandardInput.hasNext()) {
            String storeCommand = readStandardInput.next();
            if (storeCommand.equals("B")) {
                Appointment toAdd = AppointmentCreator(readStandardInput);
                if (toAdd == null || ValidApptChecker(toAdd) == false || ValidApptChecker2(toAdd) == false) {
                    continue;
                }
                addAppointmentToSchedule(toAdd);
            } else if (storeCommand.equals("C")) {
                Appointment toRemove = AppointmentCreator(readStandardInput);
                removeSingleAppointment(toRemove);
            } else if (storeCommand.equals("CP")) {
                Date dateOfBirth = new Date(readStandardInput.next());
                Patient toRemove = new Patient(readStandardInput.next(), readStandardInput.next(), dateOfBirth);
                removeAllAppointments(toRemove);
            } else if (storeCommand.equals("P")) {
                System.out.println("\n*list of appointments in the schedule*");
                allAppts.print();
                System.out.println("*end of schedule*\n");
            } else if (storeCommand.equals("PZ")) {
                System.out.println("\n*list of appointments by zip and time slot.");
                allAppts.printByZip();
                System.out.println("*end of schedule*\n");
            } else if (storeCommand.equals("PP")) {
                System.out.println("\n*list of appointments by patient.");
                allAppts.printByPatient();
                System.out.println("*end of list\n");
            } else if (storeCommand.equals("Q")) {
                System.out.println("Kiosk session ended.");
                break;
            } else {
                System.out.println("Invalid command!");
            }
        }
        readStandardInput.close();
    }
}
