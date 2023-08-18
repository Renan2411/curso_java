import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DatasFormatadas {
    public static void main(String[] args) {

        LocalDate date4 = LocalDate.parse("2022-07-20");
        LocalDateTime date5 = LocalDateTime.parse("2023-12-08T01:30:26");

        //Objetos do tipo Instant não possuí método format
        Instant date6 = Instant.parse("2022-07-20T01:30:26Z");

        DateTimeFormatter formato1  = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        DateTimeFormatter formato4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter formato5 = DateTimeFormatter.ISO_INSTANT;

        System.out.println("Data 4 = " + date4.format(formato1));
        System.out.println("Data 4 = " + formato1.format(date4));
        System.out.println("Data 4 = " + date4.format( DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Data 5 = " + date5.format(formato1));
        System.out.println("Data 5 = " + date5.format(formato2));
        System.out.println("Data 5 = " + date5.format(formato4));

        //Para DataHoras globais, é necessário informar qual o fuso que está sendo trabalhado para realziar uma conversão
        System.out.println("Data 6 = " + formato3.format(date6));
        System.out.println("Data 6 = " + formato5.format(date6));

    }
}
