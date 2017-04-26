/**
 *
 */
package by.pvt.medvedeva.education.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Anastasiya Medvedeva
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
@PrimaryKeyJoinColumn (name = "user_id")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {
    private static final long serialVersionUID = 1L;
    @OneToOne
    @PrimaryKeyJoinColumn
     private Course courses;






    @Override
    public String toString() {
        return "Teacher [name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + ", role=" + role + "]";
    }

}
