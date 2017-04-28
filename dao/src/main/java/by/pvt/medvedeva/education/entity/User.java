
package by.pvt.medvedeva.education.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

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
    String name;
    @Column(name = "surname")
    String surname;
    @Column(name = "login", unique = false)
    String login;
    @Column(name = "password")
    String password;
    @Column(name = "role", updatable = true)
    Integer role;

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
