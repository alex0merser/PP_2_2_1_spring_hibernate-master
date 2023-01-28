package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User(new Car("BMW1", 1),
                "firstname1", "lastname1", "name1@mail.ru"));
        userService.add(new User(new Car("BMW2", 2),
                "firstname2", "lastname2", "name2@mail.ru"));
        userService.add(new User(new Car("BMW3", 3),
                "firstname3", "lastname3", "name3@mail.ru"));
        userService.add(new User(new Car("BMW4", 4),
                "firstname4", "lastname4", "name4@mail.ru"));

        User user = userService.getUser("BMW1", 1);

        System.out.println(user.getId());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());

        context.close();
    }
}
