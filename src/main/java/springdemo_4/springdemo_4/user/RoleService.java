package springdemo_4.springdemo_4.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdemo_4.springdemo_4.error.NotFoundException;
import springdemo_4.springdemo_4.user.persistence.Role;
import springdemo_4.springdemo_4.user.persistence.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getRole(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Role with id " + id + " not found"));
    }

}
