package service;

import java.util.List;

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


}
