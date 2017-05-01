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

@Table (name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Course extends Pojo {
    private static final long serialVersionUID = 1L;
    @Id
    @Column (name = "course_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer courseId;
    @Column (name = "course_name")
    private String name;
    @Column (name = "duration")
    private Integer duration;
    @Column (name = "auditorium")
    private Integer auditorium;
    @OneToOne
    @JoinColumn(name = "teacher_user_id", referencedColumnName = "user_id")
     private Teacher teacher;

    @Override
    public String toString() {
        return "Course [name=" + name + ", duration=" + duration + ", auditorium=" + auditorium + ", Teacher=" + teacher + "]";
    }

}