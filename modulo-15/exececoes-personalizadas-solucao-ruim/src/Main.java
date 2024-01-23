import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        //Solução ruim pois a logica de validação está na classe principal, enquanto ela deveria estar dentro da classe responsável

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int roomNumber = sc.nextInt();

        System.out.print("Check-in data (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Check-out data (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation, Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to Update the Reservation");

            System.out.print("Check-in data (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());

            System.out.print("Check-out data (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkOut);

            if (!Objects.isNull(error)) {
                System.out.println(error);
            }else{
                System.out.println("Reservation: " + reservation);
            }
        }


        sc.close();
    }
}