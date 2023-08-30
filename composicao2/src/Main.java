import entities.Comment;
import entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        Post post1 = new Post(sdf.parse("21/06/2018 13:05:44"), "Traveling to New Zeland", "I'm going to visit this wonderful country", 12);
        Post post2 = new Post(sdf.parse("28/07/2018 13:14:19"), "Good night guys", "See you tomorrow", 5);

        post1.addComment(new Comment("Have a nice trip"));
        post1.addComment(new Comment("Wow that's awesome"));
        post2.addComment(new Comment("Good night"));
        post2.addComment(new Comment("May the force be with you"));


        System.out.println(post1);
        System.out.println(post2);
    }
}