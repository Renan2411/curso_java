package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException{

        if(!checkOut.after(checkIn)){
            throw  new DomainException("Error in reservation: Check-out date must be after check-int date");
        }

        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    //Quanto tenho uma exceção personalizada, meu método deve lançar a exceção para garantir que ela seja tratada
    public void updateDates (Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Error in reservation: Reservation dates for update must be futures dates");
        }

        if (!checkOut.after(checkIn)) {
            throw new DomainException("Error in reservation, Check-out date must be after check-in date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
