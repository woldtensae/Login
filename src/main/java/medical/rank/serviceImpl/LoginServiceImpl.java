package medical.rank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.rank.domain.User;
import medical.rank.service.LoginService;
import medical.rank.service.UserService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserService userService;
	
	@Override
	public boolean authenticate(String username, String password) {
		User currentUser =userService.getUserByUsername(username);
		if(currentUser == null)
			return false;
		else {
			if(currentUser.getPassword().equals(password))
				return true;
		}
		return false;
	}

}
