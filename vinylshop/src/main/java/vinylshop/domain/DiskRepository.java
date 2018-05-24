package vinylshop.domain;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DiskRepository extends CrudRepository <Disk, Long>{
	List<Disk> findByName(String name);
}

