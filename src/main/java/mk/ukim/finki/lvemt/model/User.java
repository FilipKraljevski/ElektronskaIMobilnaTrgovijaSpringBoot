package mk.ukim.finki.lvemt.model;

import javax.persistence.*;
import lombok.Data;
import mk.ukim.finki.lvemt.model.enumaration.Role;

@Data
@Entity
@Table(name = "library_user")
public class User {
    @Id
    private String username;

    private String password;

    private String name;

    private String surname;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String password, String name, String surname, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public User() {

    }
}
