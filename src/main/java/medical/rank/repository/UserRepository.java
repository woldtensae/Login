package medical.rank.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import medical.rank.domain.User;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long>{
	/*In order to use find By user name the username filed in the 
	 * data base must be a unique value either wise if we have 
	 * multiple value with the same user name then it will throw Incorrect 
	 * ResultSizeDataAccessException and NonUniqueResultException  */
	
	public User findByUsername(String username);
}
