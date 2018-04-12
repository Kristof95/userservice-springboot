package karma.practice02.swaggercodegen.repository.dto;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userdata", schema = "public")
public class UserDto implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId = null;

    @Column(name = "user_name")
    String username = null;

    @Column(name = "user_password")
    String password = null;

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDto() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
