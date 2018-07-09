package in.ogmatech.authorization.service;

import in.ogmatech.authorization.model.User;

import java.util.List;

public interface UserService {
    boolean isExist(User user);

    User save(User user);

    User findById(Integer idUser);

    List<User> findAll();

    User update(User user);

    void delete(Integer idUser);

    void deleteAll();
}
