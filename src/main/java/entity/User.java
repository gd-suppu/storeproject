package entity;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Data
public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
