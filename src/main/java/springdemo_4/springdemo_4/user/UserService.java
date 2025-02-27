package springdemo_4.springdemo_4.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springdemo_4.springdemo_4.error.NotFoundException;
import springdemo_4.springdemo_4.user.model.UserRequest;
import springdemo_4.springdemo_4.user.persistence.AppUser;
import springdemo_4.springdemo_4.user.persistence.AppUserRepository;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AppUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public void createUser(UserRequest request) {
        AppUser user = new AppUser();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(request.getRoleIds().stream()
                .map(roleService::getRole)
                .collect(Collectors.toSet()));

        repository.save(user);
    }

    public AppUser getUser(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new NotFoundException("User with username " + username + " not found"));
    }
}
