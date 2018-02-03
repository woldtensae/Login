package medical.rank.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.rank.domain.User;
import medical.rank.repository.UserRepository;
import medical.rank.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUser(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> allUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
