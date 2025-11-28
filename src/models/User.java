package models;

import java.util.Date;

/**
 *  The User Class
 *  content user info
 *  
 *  @author KARIM NGAMI TEUMI
 */
public class User {
	
	private final long id;
	private final String firstName;
	private final String lastName;
	private final Date creationDate;
	
	public User(long id, String firstName, String lastName, Date creationDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationDate = creationDate;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	
}
