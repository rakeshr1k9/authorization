package in.ogmatech.authorization.repository;

import in.ogmatech.authorization.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
