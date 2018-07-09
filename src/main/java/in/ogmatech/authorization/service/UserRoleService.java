package in.ogmatech.authorization.service;

import in.ogmatech.authorization.model.UserRole;

import java.util.List;

public interface UserRoleService {

    boolean isExist(UserRole user);

    UserRole save(UserRole userRole);

    UserRole findById(Integer idUserRole);

    List<UserRole> findAll();

    UserRole update(UserRole userRole);

    void delete(Integer idUserRole);

    void deleteAll();
}
