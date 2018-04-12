package karma.practice02.swaggercodegen.repository;

import karma.practice02.swaggercodegen.repository.dto.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDto, Long> {

}
