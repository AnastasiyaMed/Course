
package by.pvt.medvedeva.education.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Table(name = "user")
@Inheritance (strategy = InheritanceType.JOINED)
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends Pojo {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "id")
    int idUser;
    @Column (name = "name")
    String name;
    @Column (name = "surname")
    String surname;
    @Column (name = "login")
    String login;
    @Column (name = "password")
    String password;
    @Column (name = "role")
    int role;


    public User() {
        super();
    }

    public User(int idUser, String name, String surname, String login, String password, int role) {
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
