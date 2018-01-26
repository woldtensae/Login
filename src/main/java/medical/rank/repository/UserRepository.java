package medical.rank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import medical.rank.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public User findByUsername(String username);
}
