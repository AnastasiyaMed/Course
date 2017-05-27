
package by.pvt.medvedeva.education.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Anastasiya Medvedeva
 */
@Data
@NoArgsConstructor
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends Pojo {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Cascade(CascadeType.ALL)
    @Column(name = "id")
    Integer idUser;

    @Column(name = "name")
    @NotBlank(message = "{user.name.notblank}")
    @Size(min = 2, max = 20, message = "{user.name.size}")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "{user.name.pattern}")
    String name;

    @Column(name = "surname")
    @NotBlank(message = "{user.surname.notblank}")
    @Size(min = 2, max = 20, message = "{user.surname.size}")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я-/s]+$", message = "{user.surname.pattern}")
    String surname;

    @Column(name = "login", unique = true)
    @NotBlank(message = "{user.login.notblank}")
    @Size(min = 6, max = 20, message = "{user.login.size}")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9]+$", message = "{user.login.pattern}")
    String login;

    @Column(name = "password")
    @NotBlank(message = "{user.password.notblank}")
    @Size(min = 8, max = 32, message = "{user.password.size}")
    String password;

    @Column(name = "role", updatable = true)
    Integer role;

    /**
     *
     * @param idUser
     * @param name
     * @param surname
     * @param login
     * @param password
     * @param role
     */
    public User(Integer idUser, String name, String surname, String login, String password, Integer role) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + ", role=" + role + "]";
    }

}
