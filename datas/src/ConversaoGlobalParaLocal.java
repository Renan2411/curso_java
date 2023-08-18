import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConversaoGlobalParaLocal {
    public static void main(String[] args) {
        LocalDate date4 = LocalDate.parse("2022-07-20");
        LocalDateTime date5 = LocalDateTime.parse("2023-12-08T01:30:26");
        Instant date6 = Instant.parse("2022-07-20T01:30:26Z");

        //Convertendo Instant para localDate com base em um timezone
        LocalDate r1 = LocalDate.ofInstant(date6, ZoneId.systemDefault()); //Converte para o default do sistema
        LocalDate r2 = LocalDate.ofInstant(date6, ZoneId.of("Portugal")); //Converte para o timezone de Portugal

        //Convertendo Instant para LocalDateTime com base em um timezone
        LocalDateTime r3 = LocalDateTime.ofInstant(date6, ZoneId.systemDefault()); //Converte para o default do sistema
        LocalDateTime r4 = LocalDateTime.ofInstant(date6, ZoneId.of("Portugal")); //Converte para o timezone de Portugal


        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        System.out.println();

        System.out.println("date4 dia = " + date4.getDayOfMonth());
        System.out.println("date4 mês = " + date4.getMonth());
        System.out.println("date4 ano = " + date4.getYear());

        System.out.println();

        System.out.println("date5 hora = " + date5.getHour());
        System.out.println("date5 minuto = " + date5.getMinute());
        System.out.println("date5 segundo = " + date5.getSecond());

        //Retornar todos os timeZones disponíveis
//        for (String s : ZoneId.getAvailableZoneIds()){
//            System.out.println(s);
//        }
    }
}
