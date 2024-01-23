package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    public String updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            return "Error in reervation: Reservation dates for update must be futures dates";
        }

        if (!checkOut.after(checkIn)) {
            return "Error in reservation, Check-out date must be after check-in date";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

        return null;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();

        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "Rooom " +
                this.roomNumber +
                ", checkIn: " +
                sdf.format(this.checkIn) +
                ", checkOut: " +
                sdf.format(this.checkOut) +
                ", " +
                this.duration() +
                " nights";
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
