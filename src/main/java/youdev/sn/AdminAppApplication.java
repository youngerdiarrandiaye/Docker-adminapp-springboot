package youdev.sn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import youdev.sn.dto.RoleDto;
import youdev.sn.services.RolesService;

import java.util.stream.Stream;

@SpringBootApplication
public class AdminAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminAppApplication.class, args);
	}

	//@Bean
	CommandLineRunner commandLineRunner(RolesService rolesService){
		return args -> {
			Stream.of("Role_Tester","Role_Ing","Role_Control_Arch").forEach(nom->{
				RoleDto roleDto = new RoleDto();
				roleDto.setNom(nom);
				rolesService.createRoles(roleDto);
			});
		};
	}
}
