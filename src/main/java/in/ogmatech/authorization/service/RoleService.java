package in.ogmatech.authorization.service;

import in.ogmatech.authorization.model.Role;

import java.util.List;

public interface RoleService {

    boolean isExist(Role role);

    Role save(Role role);

    Role findById(Long idUser);

    List<Role> findAll();

    Role update(Role role);

    void delete(Long idRole);

    void deleteAll();
}
