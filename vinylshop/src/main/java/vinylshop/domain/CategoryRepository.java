package vinylshop.domain;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByCategoryname(String categoryname);
    
}