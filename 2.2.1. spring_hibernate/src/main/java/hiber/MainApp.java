package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car model1 = new Car("Audi", 111);
        Car model2 = new Car("Toyota", 222);
        Car model3 = new Car("model3", 333);
        Car model4 = new Car("model4", 444);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", model1 ));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", model2));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", model3));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", model4));

//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println("Car = " + user.getCar());
//            System.out.println();
//        }
        System.out.println("-------------------");

        List<User> usersOfCar;
        usersOfCar = userService.getUserOfCar(model1.getModel(), model1.getSeries());
        for (User user : usersOfCar) {
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
