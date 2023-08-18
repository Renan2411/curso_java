import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculosDataHora {
    public static void main(String[] args) {
        LocalDate date4 = LocalDate.parse("2022-07-20");
        LocalDateTime date5 = LocalDateTime.parse("2023-12-08T01:30:26");
        Instant date6 = Instant.parse("2022-07-20T01:30:26Z");

        LocalDate pastWeekLocalDate = date4.minusWeeks(1); //Adiciona uma semana na data
        LocalDate nextWeekLocalDate = date4.plusWeeks(1); //Remove uma semana na data

        LocalDateTime pastWeekLocalDateTime = date5.minusWeeks(1); //Adiciona uma semana na data
        LocalDateTime nextWeekLocalDateTime = date5.plusWeeks(1); //Remove uma semana na data
        LocalDateTime nextHourLocalDateTime = date5.plusHours(1); //Adicionando uma hora na data

        Instant pastWeekInstant = date6.minus(7, ChronoUnit.DAYS); //Utiliza a biblioteca para saber o que reduzir. nessa caso, dias

        //Calculando Durações
        Duration tempo1 = Duration.between(pastWeekLocalDateTime, date5); //Calcula a duração entre duas datas

        //Duration tempo2 = Duration.between(pastWeekLocalDate, date4); //Não se pode calcular duração entre dois localDate, sendo necessária a conversão para LocalDateTime
        Duration tempo2 = Duration.between(pastWeekLocalDate.atTime(0, 0), date4.atTime(0, 0)); //Convertendo localDate para localDateTime com atTime()
        Duration tempo21 = Duration.between(pastWeekLocalDate.atStartOfDay(), date4.atStartOfDay()); //Convertendo localDate para localDateTime com atStartOfDay(), que pega 0h

//        Duration tempo3 = Duration.between(pastWeekInstant, date6);
        Duration tempo3 = Duration.between(date6, pastWeekInstant);


        System.out.println("Date4 menos uma semana = " + pastWeekLocalDate);
        System.out.println("Date4 mais uma semana = " + nextWeekLocalDate);

        System.out.println();

        System.out.println("Date5 menos uma semana = " + pastWeekLocalDateTime);
        System.out.println("Date5 mais uma semana = " + nextWeekLocalDateTime);
        System.out.println("Date5 mais uma hora = " + nextHourLocalDateTime);

        System.out.println();

        System.out.println("Date6 menos uma semana = " + pastWeekInstant);

        System.out.println();

        System.out.println("tempo1 dias = " + tempo1);
        System.out.println("tempo1 dias = " + tempo1.toDays());
        System.out.println("tempo2 dias = " + tempo2.toDays());
        System.out.println("tempo3 dias = " + tempo3.toDays());


    }
}
