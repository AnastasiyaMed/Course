/**
 *
 */
package by.pvt.medvedeva.education.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Anastasiya Medvedeva
 */
@Data
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {
    private static final long serialVersionUID = 1L;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Course courses;


    public Teacher(Integer idUser, String name, String surname, String login, String password, Integer role) {
        super(idUser, name, surname, login, password, role);
    }

    public Teacher() {
        super();
    }

    @Override
    public String toString() {
        return "Teacher [name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + ", role=" + role + "]";
    }

}
