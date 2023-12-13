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
        if (years == 0) {
            return false;
        }

        switch (month) {
            case "JAN" ->
                word = 1;
            case "FEB" ->
                word = 2;
            case "MAR" ->
                word = 3;
            case "APR" ->
                word = 4;
            case "MAY" ->
                word = 5;
            case "JUN" ->
                word = 6;
            case "JUL" ->
                word = 7;
            case "AUG" ->
                word = 8;
            case "SEP" ->
                word = 9;
            case "OCT" ->
                word = 10;
            case "NOV" ->
                word = 11;
            case "DEC" ->
                word = 12;

        }

        switch (word) {
            case 4, 6, 9, 11 -> {
                if (day <= 30) {
                    return true;
                } else {
                    return false;
                }
            }
            case 1, 3, 5, 7, 8, 10, 12 -> {
                if (day <= 31) {
                    return true;
                } else {
                    return false;
                }
            }
            case 2 -> {
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
            }
            default -> {
                return false;
            }
        }

    }

    //ToString
    public String toString() {
        return String.format("%-2d %3s %4d (%s)", day, month, years, timeSlot);
    }

}
