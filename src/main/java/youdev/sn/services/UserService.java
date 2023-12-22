package youdev.sn.services;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import youdev.sn.dao.IRolesRepository;
import youdev.sn.dao.IUserRepository;
import youdev.sn.dto.RoleDto;
import youdev.sn.dto.UserDto;
import youdev.sn.exception.EntityNotFoundException;
import youdev.sn.exception.RequestException;
import youdev.sn.mapping.RolesMapper;
import youdev.sn.mapping.UserMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    private IUserRepository iUserRepository;
    private UserMapper userMapper;
    MessageSource messageSource;

    public UserService(IUserRepository iUserRepository, UserMapper userMapper, MessageSource messageSource) {
        this.iUserRepository = iUserRepository;
        this.userMapper = userMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<UserDto> getUsers() {
        return StreamSupport.stream(iUserRepository.findAll().spliterator(), false)
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDto getUsers(int id) {
        return userMapper.toUserDto(iUserRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }
    @Transactional
    public UserDto createUsers(UserDto userDto) {
        return userMapper.toUserDto(iUserRepository.save(userMapper.fromUserDto(userDto)));
    }

    @Transactional
    public void deleteUsers(int id) {
        try {
            iUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
