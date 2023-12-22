package youdev.sn.mapping;

import org.mapstruct.Mapper;
import youdev.sn.dto.UserDto;
import youdev.sn.entities.UserEntity;

@Mapper
public interface UserMapper {
    UserDto toUserDto(UserEntity userEntity);
    UserEntity fromUserDto(UserDto userDto);
}
