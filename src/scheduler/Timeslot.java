package scheduler;


/**
 This class takes an appointment date and time and returns them as a string, and it also compares a timeslot object
 to another timeslot object. There are constructors for timeslot objects and getter methods for retrieving the
 information held by instance variables.
 @author Karan Patel, Azaan Siddiqi
 */
public class Timeslot implements Comparable<Timeslot> {
    private Date date;
    private Time time;


    /**
     Creates a timeslot object consisting of a date object and a time object.
     @param date a date object that consists of the month, day, and year in the form mm/dd/yyyy.
     @param time a time object that consists of the time in hours and minutes in the form hh:mm.
     */
    public Timeslot(Date date, Time time) {
        this.date = date;
        this.time = time;
    }


    /**
     Returns the appointment date associated with the Timeslot object.
     @return the date object associated with the timeslot object.
     */
    public Date getDate() {
        return this.date;
    }


    /**
     Returns the appointment time associated with the Timeslot object.
     @return the time object associated with the timeslot object.
     */
    public Time getTime() {
        return this.time;
    }


    /**
     Converts a given appointment date and time to a string and returns it.
     @return A String representing the date and time in the form of mm/dd/yyyy, hh:mm.
     */
    @Override
    public String toString() {
        return date.toString() + ", " + time.toString();
    }


    /**
     Compares a timeslot object to another timeslot object.
     @param slot the timeslot object to be compared to another timeslot object.
     @return -1 if the first timeslot object is smaller, 0 if both timeslot objects are equal, 1 if the first timeslot
     object is bigger.
     */
    @Override
    public int compareTo(Timeslot slot) {
        if (this.date.compareTo(slot.date) != 0) {
            return this.date.compareTo(slot.date);
        }
        else {
            return this.time.compareTo(slot.time);
        }
    }


    /**
     Testbed main for the timeslot class to test the compareTo() method.
     @param args Array to store the java command line arguments.
     */
    public static void main(String[] args){
        Timeslot timeslotTestCase1 = new Timeslot(new Date("1/2/2022") , new Time(9,30));//Test case #1
        Timeslot timeslotTestCase1Compare = new Timeslot(new Date("1/2/2022") , new Time(9,45));//Test case #1
        System.out.println("Test case 1: The timeslot " + timeslotTestCase1 + " compared to " + timeslotTestCase1Compare +
                " returns " + timeslotTestCase1.compareTo(timeslotTestCase1Compare));// Test case #1

        Timeslot timeslotTestCase2 = new Timeslot(new Date("1/2/2022") , new Time(9,30));//Test case #2
        Timeslot timeslotTestCase2Compare = new Timeslot(new Date("1/2/2022") , new Time(9,30));//Test case #2
        System.out.println("Test case 2: The timeslot " + timeslotTestCase2 + " compared to " + timeslotTestCase2Compare +
                " returns " + timeslotTestCase2.compareTo(timeslotTestCase2Compare));//Test case #2

        Timeslot timeslotTestCase3 = new Timeslot(new Date("1/2/2022") , new Time(9,30));//Test case #3
        Timeslot timeslotTestCase3Compare = new Timeslot(new Date("1/2/2022") , new Time(9,15));//Test case #3
        System.out.println("Test case 3: The timeslot " + timeslotTestCase3 + " compared to " + timeslotTestCase3Compare +
                " returns " + timeslotTestCase3.compareTo(timeslotTestCase3Compare));//Test case #3

        Timeslot timeslotTestCase4 = new Timeslot(new Date("1/2/2022") , new Time(10,00));//Test case #4
        Timeslot timeslotTestCase4Compare = new Timeslot(new Date("1/2/2022") , new Time(11,00));//Test case #4
        System.out.println("Test case 4: The timeslot " + timeslotTestCase4 + " compared to " + timeslotTestCase4Compare +
                " returns " + timeslotTestCase4.compareTo(timeslotTestCase4Compare));//Test case #4

        Timeslot timeslotTestCase5 = new Timeslot(new Date("1/2/2022") , new Time(10,00));//Test case #5
        Timeslot timeslotTestCase5Compare = new Timeslot(new Date("1/2/2022") , new Time(9,00));//Test case #5
        System.out.println("Test case 5: The timeslot " + timeslotTestCase5 + " compared to " + timeslotTestCase5Compare +
                " returns " + timeslotTestCase5.compareTo(timeslotTestCase5Compare));//Test case #5

        Timeslot timeslotTestCase6 = new Timeslot(new Date("3/2/2022") , new Time(9,45));//Test case #6
        Timeslot timeslotTestCase6Compare = new Timeslot(new Date("3/2/2022") , new Time(11,30));//Test case #6
        System.out.println("Test case 6: The timeslot " + timeslotTestCase6 + " compared to " + timeslotTestCase6Compare +
                " returns " + timeslotTestCase6.compareTo(timeslotTestCase6Compare));//Test case #6

        Timeslot timeslotTestCase7 = new Timeslot(new Date("3/2/2022") , new Time(11,15));//Test case #7
        Timeslot timeslotTestCase7Compare = new Timeslot(new Date("3/2/2022") , new Time(10,30));//Test case #7
        System.out.println("Test case 7: The timeslot " + timeslotTestCase7 + " compared to " + timeslotTestCase7Compare +
                " returns " + timeslotTestCase7.compareTo(timeslotTestCase7Compare));//Test case #7

        Timeslot timeslotTestCase8 = new Timeslot(new Date("3/2/2022") , new Time(10,00));//Test case #8
        Timeslot timeslotTestCase8Compare = new Timeslot(new Date("3/3/2022") , new Time(9,00));//Test case #8
        System.out.println("Test case 8: The timeslot " + timeslotTestCase8 + " compared to " + timeslotTestCase8Compare +
                " returns " + timeslotTestCase8.compareTo(timeslotTestCase8Compare));//Test case #8

        Timeslot timeslotTestCase9 = new Timeslot(new Date("3/2/2022") , new Time(11,15));//Test case #9
        Timeslot timeslotTestCase9Compare = new Timeslot(new Date("3/1/2022") , new Time(11,15));//Test case #9
        System.out.println("Test case 9: The timeslot " + timeslotTestCase9 + " compared to " + timeslotTestCase9Compare +
                " returns " + timeslotTestCase9.compareTo(timeslotTestCase9Compare));//Test case #9

        Timeslot timeslotTestCase10 = new Timeslot(new Date("2/4/2022") , new Time(16,00));//Test case #10
        Timeslot timeslotTestCase10Compare = new Timeslot(new Date("3/3/2022") , new Time(16,15));//Test case #10
        System.out.println("Test case 10: The timeslot " + timeslotTestCase10 + " compared to " + timeslotTestCase10Compare +
                " returns " + timeslotTestCase10.compareTo(timeslotTestCase10Compare));//Test case #10

        Timeslot timeslotTestCase11 = new Timeslot(new Date("4/1/2022") , new Time(10,00));//Test case #11
        Timeslot timeslotTestCase11Compare = new Timeslot(new Date("2/2/2022") , new Time(9,00));//Test case #11
        System.out.println("Test case 11: The timeslot " + timeslotTestCase11 + " compared to " + timeslotTestCase11Compare +
                " returns " + timeslotTestCase11.compareTo(timeslotTestCase11Compare));//Test case #11

        Timeslot timeslotTestCase12 = new Timeslot(new Date("5/7/2020") , new Time(12,00));//Test case #12
        Timeslot timeslotTestCase12Compare = new Timeslot(new Date("3/3/2022") , new Time(13,15));//Test case #12
        System.out.println("Test case 12: The timeslot " + timeslotTestCase12 + " compared to " + timeslotTestCase12Compare +
                " returns " + timeslotTestCase12.compareTo(timeslotTestCase12Compare));//Test case #12

        Timeslot timeslotTestCase13 = new Timeslot(new Date("1/1/2024") , new Time(14,00));//Test case #13
        Timeslot timeslotTestCase13Compare = new Timeslot(new Date("3/2/2022") , new Time(15,15));//Test case #13
        System.out.println("Test case 13: The timeslot " + timeslotTestCase13 + " compared to " + timeslotTestCase13Compare +
                " returns " + timeslotTestCase13.compareTo(timeslotTestCase13Compare));//Test case #13

    }
}
