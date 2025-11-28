import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.SortDirection;
import models.User;
import service.UserService;

public class Main {

	public static void main(String[] args) {
	
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Karim", "Ngami", new Date(System.currentTimeMillis() - 10L * 24 * 60 * 60 * 1000)));
        users.add(new User(2, "Bill", "calhoun", new Date(System.currentTimeMillis() - 15L * 24 * 60 * 60 * 1000)));
        users.add(new User(3, "Wei", "Wong", new Date(System.currentTimeMillis() - 300L * 24 * 60 * 60 * 1000)));
        users.add(new User(4, "Donald", "Peter", new Date(System.currentTimeMillis() - 100L * 24 * 60 * 60 * 1000)));

        User userFound = UserService.getUserById(users, 3);
        if (userFound != null) {
            System.out.println("Found user: " + userFound.getFirstName() + " " + userFound.getLastName());
        } else {
            System.out.println("User not found");
        }

        // Test sorting by last name ASC
        System.out.println("\nUsers sorted by last name ASC:");
        List<User> sortedAsc = UserService.sortUsersByLastName(users);
        sortedAsc.forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName()));

        // Test sorting by last name DESC 
        System.out.println("\nUsers sorted by last name DESC:");
        List<User> sortedDesc = UserService.sortUsersByLastName(users, SortDirection.DESC);
        sortedDesc.forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName()));

        // Test days since creation 
        System.out.println("\nDays since user creation:");
        for (User u : users) {
            long days = UserService.daysSinceCreation(u);
            System.out.println(u.getFirstName() + " " + u.getLastName() + ": " + days + " days");
        }
	}

}
