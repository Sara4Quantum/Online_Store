package Store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
// Component annotation to mark this interface as a Spring component.
@Component

// CrudRepository interface for performing CRUD operations on Purchase_OrderDetails entities.
// The first type parameter (Purchase_OrderDetails) is the entity type managed by this repository.
// The second type parameter (Integer) is the type of the primary key of the entity.

public interface purchase_orderDetailsCRUD extends CrudRepository<Purchase_OrderDetails, Integer> {


}
