package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import enums.SortDirection;
import models.User;

/**
 * The UserService class
 * 
 * Contains utility methods related to User objects.
 * 
 * @author KARIM NGAMI TEUMI
 */
public class UserService {
	
	/**
     * Retrieves a user by ID from a list of users.
     * 
     * @param users : the list of users to search
     * @param id : the ID being searched for
     * @return User:  if found, otherwise NULL
     */
    public static User getUserById(List<User> users, long id) {
        if (users == null)
            throw new IllegalArgumentException("Users list cannot be null");

        return users.stream()
                .filter(user -> user != null && user.getId() == id)
                .findFirst().orElse(null);
    }
    
    /**
     * Sorts a list of users by last name in a given direction.
     *
     * @param users: the list of users to sort
     * @param direction: sort direction (ASC or DESC)
     * @return sorted: list of users
     */
    public static List<User> sortUsersByLastName(List<User> users, SortDirection direction) {
        
        if (users == null)
            throw new IllegalArgumentException("Users list cannot be null");
        
        if (direction == null)
            direction = SortDirection.ASC;

        List<User> result = new ArrayList<>(users);
        
        Comparator<String> lastNameComparator = Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER);
        result.sort(direction == SortDirection.ASC
                ? Comparator.comparing(User::getLastName, lastNameComparator)
                : Comparator.comparing(User::getLastName, lastNameComparator).reversed()
        );

        return result;
    }

    /**
     * Sorts a list of users by last name in ascending order (default).
     *
     * @param users: the list of users to sort
     * @return sorted: list of users (ASC)
     */
    public static List<User> sortUsersByLastName(List<User> users) {
        
        if (users == null)
            throw new IllegalArgumentException("Users list cannot be null");
        
        return sortUsersByLastName(users, SortDirection.ASC);
    }



}
