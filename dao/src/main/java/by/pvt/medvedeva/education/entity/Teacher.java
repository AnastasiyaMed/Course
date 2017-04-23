/**
 *
 */
package by.pvt.medvedeva.education.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author Anastasiya Medvedeva
 */
@Data
@Table(name = "teacher")
@PrimaryKeyJoinColumn (name = "user_id")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {
    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @Column (name = "teacher_id")
    private int idTeacher;
//    @OneToOne
//    @JoinColumn(name="teacher_id")
//     private Course courses;

    public Teacher() {
        super();
    }

    public Teacher(int idTeacher, int idUser, String name, String surname, String login, String password, int role) {
        super(idUser, name, surname, login, password, role);
        this.idTeacher = idTeacher;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }





    @Override
    public String toString() {
        return "Teacher [name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + ", role=" + role + "]";
    }

}
