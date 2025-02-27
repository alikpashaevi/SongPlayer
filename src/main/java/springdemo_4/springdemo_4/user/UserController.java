package springdemo_4.springdemo_4.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springdemo_4.springdemo_4.user.model.UserRequest;

import static springdemo_4.springdemo_4.constants.AuthorizationConstants.ADMIN;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@PreAuthorize(ADMIN)
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody @Valid UserRequest request) {
        userService.createUser(request);
    }

}
