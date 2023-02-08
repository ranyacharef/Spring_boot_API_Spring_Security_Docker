package io.getarrays.api.init;

import io.getarrays.api.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import io.getarrays.api.model.Role;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
@Component
public class ApplicationStartRunner implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role(1L, "123", "ROLE_USER");
        Role roleAdmin = new Role(2L, "456", "ROLE_ADMIN");
        roleRepository.saveAll(asList(roleUser,roleAdmin));
    }
}
