package medical.rank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import medical.rank.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUsername(String username);
}
