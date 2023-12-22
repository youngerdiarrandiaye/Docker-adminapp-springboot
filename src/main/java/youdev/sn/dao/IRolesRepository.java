package youdev.sn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import youdev.sn.entities.RoleEntity;

public interface IRolesRepository extends JpaRepository<RoleEntity, Integer> {
}
