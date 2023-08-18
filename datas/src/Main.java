import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        //Criando um formato para ser utilizado. Usando formato com padrões
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        //Instanciando uma data local atual
        LocalDate date1 = LocalDate.now();

        //Intanciando uma data-hora local atual
        LocalDateTime date2 = LocalDateTime.now();

        //Instanciando uma data-hora global
        Instant date3 = Instant.now();

        //Convertendo data-hota texto no padrão ISO 8601 para o padrão datetime
        LocalDate date4 = LocalDate.parse("2022-07-20");
        LocalDateTime date5 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant date6 = Instant.parse("2022-07-20T01:30:26Z");

        //Fazendo a conversão de um fuso diferente para o GMT
//        Instant date7 = Instant.parse("2022-07-23T14:52:09Z+03:00");

        //conversão formata
        LocalDate date8 = LocalDate.parse("15/08/2023", formato1);
        LocalDateTime date9 = LocalDateTime.parse("20/01/2023 01:30", formato2);

        //Data passando dados isolados
        LocalDate date10 = LocalDate.of(2023, 12, 12);
        LocalDateTime date11 = LocalDateTime.of(2023, 12, 12, 23, 45);

        System.out.println("Data Local: " + date1);
        System.out.println("Data Hora Local: " + date2);
        System.out.println("Data Hora Global: " + date3);
        System.out.println("Data Local convertida: " + date4);
        System.out.println("Data Hora Local convertida: " + date5);
        System.out.println("Data Hora Global convertida: " + date6);
//        System.out.println("Data Hora Global convertida: " + date7);
        System.out.println("Data Local Convertida a partir de um padrão: " + date8);
        System.out.println("Data Hora Local Convertida a partir de um padrão: " + date9);
        System.out.println("Data Hora criada a partir de dados: " + date10);
        System.out.println("Data Hora criada a partir de dados: " + date11);
    }
}