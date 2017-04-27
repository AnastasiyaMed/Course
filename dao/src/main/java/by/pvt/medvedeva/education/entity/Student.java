/**
 *
 */
package by.pvt.medvedeva.education.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Anastasiya Medvedeva
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@PrimaryKeyJoinColumn (name = "user_id", referencedColumnName = "id")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Student extends User {
    private static final long serialVersionUID = 1L;
    @Column (name = "level")
    private int level;
    @Column (name = "average")
    private double average;
    @Column (name = "student_id_card")
    private int studentIdCard;




      @Override
    public String toString() {
        return "Student [level=" + level + ", average=" + average + ", studentIdCard=" + studentIdCard + ", name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + ", role=" + role + "]";
    }

}
