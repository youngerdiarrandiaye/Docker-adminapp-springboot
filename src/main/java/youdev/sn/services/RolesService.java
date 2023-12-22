package youdev.sn.services;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import youdev.sn.dao.IRolesRepository;
import youdev.sn.dto.RoleDto;
import youdev.sn.exception.EntityNotFoundException;
import youdev.sn.exception.RequestException;
import youdev.sn.mapping.RolesMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RolesService {
    private IRolesRepository iRolesRepository;
    private RolesMapper rolesMapper;
    MessageSource messageSource;

    public RolesService(IRolesRepository iRolesRepository, RolesMapper rolesMapper, MessageSource messageSource) {
        this.iRolesRepository = iRolesRepository;
        this.rolesMapper = rolesMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<RoleDto>  getRoles() {
        return StreamSupport.stream(iRolesRepository.findAll().spliterator(), false)
                .map(rolesMapper::toRoleDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RoleDto getRole(int id) {
        return rolesMapper.toRoleDto(iRolesRepository.findById(id)
                .orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public RoleDto createRoles(RoleDto roleDto) {
        return rolesMapper.toRoleDto(iRolesRepository.save(rolesMapper.fromRoleDto(roleDto)));
    }

    @Transactional
    public RoleDto updateRoles(int id, RoleDto roleDto) {
        return iRolesRepository.findById(id)
                .map(entity -> {
                    roleDto.setId(id);
                    return rolesMapper.toRoleDto(
                            iRolesRepository.save(rolesMapper.fromRoleDto(roleDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteRoles(int id) {
        try {
            iRolesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
