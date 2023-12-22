package youdev.sn.mapping;

import org.mapstruct.Mapper;
import youdev.sn.dto.RoleDto;
import youdev.sn.entities.RoleEntity;

@Mapper
public interface RolesMapper {
    RoleDto toRoleDto(RoleEntity roleEntity);
    RoleEntity fromRoleDto(RoleDto roleDto);
}
