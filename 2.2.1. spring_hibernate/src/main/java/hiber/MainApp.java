package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Toyota", 3);
        Car car2 = new Car("Tesla", 5);
        Car car3 = new Car("Honda", 12);
        Car car4 = new Car("Toyota", 5);
        Car car5 = new Car("Toyota", 5);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
        User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
        User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));
        userService.add(new User("User5", "Lastname5", "user5@mail.ru", car5));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        context.close();
    }
}
