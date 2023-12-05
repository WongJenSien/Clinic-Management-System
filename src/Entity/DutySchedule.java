/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author jensienwong
 */
public class DutySchedule {

    private String month;
    private int day;
    private int years;

    private Time timeSlot;
    private boolean status;

    public DutySchedule() {
    }

    public DutySchedule(int day, String month, int years) {
        this.month = month;
        this.day = day;
        this.years = years;
    }

    public DutySchedule(int day, String month, int years, Time timeSlot) {
        this.month = month;
        this.day = day;
        this.years = years;
        this.timeSlot = timeSlot;
        status = true;// valid time-slot
    }

    //Getter
    public String getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYears() {
        return years;
    }

    public Time getTimeSlot() {
        return timeSlot;
    }

    public boolean getStatus() {
        return status;
    }

    //Setter
    public void setMonth(String month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setTimeSlot(Time timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //METHOD
    public boolean checkValidDate() {
        int word = 0;
        switch (month) {
            case "JAN":
                word = 1;
                break;
            case "FEB":
                word = 2;
                break;
            case "MAR":
                word = 3;
                break;
            case "APR":
                word = 4;
                break;
            case "MAY":
                word = 5;
                break;
            case "JUN":
                word = 6;
                break;
            case "JUL":
                word = 7;
                break;
            case "AUG":
                word = 8;
                break;
            case "SEP":
                word = 9;
                break;
            case "OCT":
                word = 10;
                break;
            case "NOV":
                word = 11;
                break;
            case "DEC":
                word = 12;
                break;

        }

        switch (word) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (day <= 30) {
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day <= 31) {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (years / 4 == 0) {
                    if (day <= 29) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (day <= 28) {
                        return true;
                    } else {
                        return false;
                    }
                }
            default:
                return false;
        }
    }

    //ToString
    public String toString() {
        return String.format("%-2d %3s %4d (%s)", day, month, years, timeSlot);
    }

}
