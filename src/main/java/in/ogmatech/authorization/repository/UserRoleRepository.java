package in.ogmatech.authorization.repository;

import in.ogmatech.authorization.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
