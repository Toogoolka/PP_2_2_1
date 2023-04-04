package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarServiece;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarServiece carServiece = context.getBean(CarServiece.class);

        User user1 = new User("Oleg", "Levanov", "oleg.l@mail.ru");
        User user2 = new User("Ivan", "Ivanov", "ivan.i@mail.ru");
        User user3 = new User("Alexandr", "Petrov", "alex.p@mail.ru");
        User user4 = new User("Sergei", "Erchilov", "sergei.e@mail.ru");

        Car car1 = new Car("Bmw", 988);
        Car car2 = new Car("Lada", 762);
        Car car3 = new Car("Lada", 356);
        Car car4 = new Car("Chevrolett", 421);


        //   set cars to users

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        System.out.println("\nАвто принадлежит: " + carServiece.getUserByCar(car3.getModel(), car3.getSeries()) + "\n");


//        List<User> users = userService.listUsers();
//        System.out.println("***************************************************");
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println("Car: " + user.getCar());
//            System.out.println();
//        }

        context.close();
    }
}
