package medical.rank.service;

import medical.rank.domain.User;

public interface LoginService {
    User authenticate(String username, String password);
}
