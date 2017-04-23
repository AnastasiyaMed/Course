/**
 *
 */
package by.pvt.medvedeva.education.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anastasiya Medvedeva
 */

@Table(name = "student")
@PrimaryKeyJoinColumn (name = "user_id")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends User {
    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @Column (name = "student_id")
    private int idStudent;
    @Column (name = "level")
    private int level;
    @Column (name = "average")
    private double average;
    @Column (name = "student_id_card")
    private int studentIdCard;
//    @OneToMany (mappedBy = "course_course_id", orphanRemoval = false)
//   // @JoinColumn(name="course_id")
//    private Set<Course> courses = new HashSet<>();

    public Student() {
        super();
    }

    public Student(int idStudent, int level, int average, int studentIdCard, int idUser, String name, String surname, String login, String password, int role) {
        super(idUser, name, surname, login, password, role);
        this.idStudent = idStudent;
        this.level = level;
        this.average = average;
        this.studentIdCard = studentIdCard;
    }





    @Override
    public String toString() {
        return "Student [level=" + level + ", average=" + average + ", studentIdCard=" + studentIdCard + ", name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + ", role=" + role + "]";
    }

}
