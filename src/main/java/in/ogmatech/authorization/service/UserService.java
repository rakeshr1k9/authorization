package in.ogmatech.authorization.service;

import in.ogmatech.authorization.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    void delete(long id);
}
