package youdev.sn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import youdev.sn.dto.RoleDto;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RolesServiceTest {
   /* @Autowired
    private RolesService rolesService;

    @Test
    void getRoles() {
        RoleDto roleDto =rolesService.getRole(1);
        Assertions.assertNotNull(roleDto);
    }

    @Test
    void getRole() {
    }

    @Test
    void createRoles() {
        RoleDto roleDto = new RoleDto();
        //roleDto.setNom("ROLE_COACH");
         roleDto.setNom("ROLE_MANAGER");
        //roleDto.setNom("ROLE_LEAD");
        RoleDto saveRole= rolesService.createRoles(roleDto);
        //Assertions.assertNotNull(saveRole);
        //Assertions.assertEquals(roleDto.getNom(),saveRole.getNom());
    }

    @Test
    void updateRoles() {
    }

    @Test
    void deleteRoles() {
         rolesService.deleteRoles(3);
         Assertions.assertTrue(true);
    }*/
}