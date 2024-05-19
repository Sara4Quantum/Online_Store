package Store;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Component annotation to mark this class as a Spring component.
@Component

// Entity annotation to specify that this class is mapped to a database entity.
@Entity

// Table annotation to specify the name of the database table for this entity.
@Table(name = "user_details")
public class User_Details {

    @Id
    private String UsernamE; // Primary key field representing the username.

    // Getter method for retrieving the username.
    public String getUsernamE() {
        return UsernamE;
    }

    // Setter method for setting the username.
    public void setUsernamE(String usernamE) {
        UsernamE = usernamE;
    }
}
