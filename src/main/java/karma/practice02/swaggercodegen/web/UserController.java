package karma.practice02.swaggercodegen.web;


import io.swagger.annotations.ApiParam;
import karma.practice02.swaggercodegen.User;
import karma.practice02.swaggercodegen.UserApi;
import karma.practice02.swaggercodegen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class UserController implements UserApi {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}


    @Override
    public ResponseEntity<Void> deleteUserById(@ApiParam(value = "specific user id", required = true) @PathVariable("userId") Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<User>> loadAllUser() {
        List<User> users = userService.listAllUser();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> loadUserById(
            @ApiParam(value = "specific dummy id", required = true) @PathVariable("userId") Long userId) {
        Optional<User> user = userService.findUserById(userId);
       if(!user.isPresent()) {
           throw new NullPointerException("User id is null!");
       } return ResponseEntity.ok(user.get());
    }

    @Override
    public ResponseEntity<User> register(
            @ApiParam(value = "Request for registering a user", required = true) @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().build();
    }
}
