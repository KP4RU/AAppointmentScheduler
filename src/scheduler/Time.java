package scheduler;
import java.text.DecimalFormat;


/**
 This class takes a given hour and minute and checks if it's a valid appointment time, converts the given
 hour and minute to a string, and compares the time to another time object. There are also two parameterized
 constructors that either take in two integers or a string in order to make time objects.
 @author Karan Patel, Azaan Siddiqi
 */
public class Time implements Comparable<Time> {

    private int hour;
    private int minute;

    public static final int FIRST_APPOINTMENT_TIME = 9;
    public static final int LAST_APPOINTMENT_TIME = 16;
    public static final int ZERO_MINUTE_APPOINTMENT = 0;
    public static final int FIFTEEN_MINUTE_APPOINTMENT = 15;
    public static final int THIRTY_MINUTE_APPOINTMENT = 30;
    public static final int FOURTY_FIVE_MINUTE_APPOINTMENT = 45;
    public static final int NUMBER_OF_TIME_COMPONENTS = 2;


    /**
     Creates a time object in the form of hh:mm.
     @param hour the hour portion of the time object in 24 hour time.
     @param minute the minute portion of the time object.
     */
    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }


    /**
     Creates a time object in the form of hh:mm.
     @param time the time in hh:mm, but it is in the form of a string.
     */
    public Time(String time) {
        String[] separateHoursAndMinutes = time.split(":");
        int[] convertTimeToInt = new int[NUMBER_OF_TIME_COMPONENTS];
        for (int i = 0; i < convertTimeToInt.length; i++) {
            convertTimeToInt[i] = Integer.parseInt(separateHoursAndMinutes[i]);
        }
        this.hour = convertTimeToInt[0];
        this.minute = convertTimeToInt[1];
    }


    /**
     Checks if a given hour and minute is a valid appointment time.
     @return true if the time is valid. false if the time is not valid.
     */
    public boolean isValid() {
        if (this.hour < FIRST_APPOINTMENT_TIME || this.hour > LAST_APPOINTMENT_TIME) {
            return false;
        }
        if (this.minute == ZERO_MINUTE_APPOINTMENT || this.minute == FIFTEEN_MINUTE_APPOINTMENT ||
            this.minute == THIRTY_MINUTE_APPOINTMENT || this.minute == FOURTY_FIVE_MINUTE_APPOINTMENT) {
            return true;
        } else {
            return false;
        }
    }


    /**
     Converts a given hour and minute to a string.
     @return A string representing the time in the form of hh:mm.
     */
    @Override
    public String toString() {
        DecimalFormat addPaddingZeroToMinutes = new DecimalFormat("#00");
        return this.hour + ":" + addPaddingZeroToMinutes.format(this.minute);
    }


    /**
     Compares a time object to another time object.
     @param time the time object that is compared to the other time object.
     @return -1 if the first time is smaller, 0 if both times are equal, 1 if the first time is greater.
     */
    @Override
    public int compareTo(Time time) {
        if (this.hour - time.hour < 0) {
            return -1;
        } else if (this.hour - time.hour > 0) {
            return 1;
        } else if (this.minute - time.minute < 0) {
            return -1;
        } else if (this.minute - time.minute > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
