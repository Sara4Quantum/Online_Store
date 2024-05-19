package Store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Repository annotation to mark this interface as a Spring repository.
@Repository
public interface User_Details_CRUD extends CrudRepository<User_Details, String> {


}
