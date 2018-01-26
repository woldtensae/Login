package medical.rank.service;

import java.util.List;

import medical.rank.domain.User;

public interface UserService {
	User getUserByUsername(String username);
	User getUser(Long id);
	List<User> allUsers();
	void remove(Long id);
	void save(User user);
	

}
