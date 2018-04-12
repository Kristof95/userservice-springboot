package karma.practice02.swaggercodegen.service;


import karma.practice02.swaggercodegen.User;
import karma.practice02.swaggercodegen.repository.UserRepository;
import karma.practice02.swaggercodegen.repository.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public void save(User user) {
        UserDto userDto = mapToEntity(user);
        userRepository.save(userDto);
    }

    public Optional<User> findUserById(Long userId) {
        Optional<UserDto> userDto = userRepository.findById(userId);
        return entityToOptionalUser(userDto);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<User> listAllUser() {
        List<UserDto> userdtos = (List<UserDto>) userRepository.findAll();
        return userDtoListToUser(userdtos);
    }

    private UserDto mapToEntity(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    private User entityToUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private Optional<User> entityToOptionalUser(Optional<UserDto> userDto) {
        Optional<User> userOpt = Optional.of(new User());
        User user = userOpt.get();
        user.setUserId(userDto.get().getUserId());
        user.setUsername(userDto.get().getUsername());
        user.setPassword(userDto.get().getPassword());
        return userOpt;
    }

    private List<User> userDtoListToUser(List<UserDto> userDtos) {
        List<User> users = new ArrayList<>();
        for (UserDto dto : userDtos) {
            if(dto != null) {
                users.add(entityToUser(dto));
            }
        }
        return users;
    }
}
