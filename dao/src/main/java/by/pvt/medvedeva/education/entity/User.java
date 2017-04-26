
package by.pvt.medvedeva.education.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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





    @Override
    public String toString() {
        return "User [name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + ", role=" + role + "]";
    }

}
