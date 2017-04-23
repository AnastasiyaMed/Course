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

@Table (name = "course")
@Data
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
    private Integer idTeacher;
//    @OneToOne(mappedBy = "course", orphanRemoval = false)
  //  @JoinColumn(name="teacher_id")
 //     private Teacher teacher;
 //   @OneToMany (mappedBy = "student_has_course", orphanRemoval = false)
//    @JoinColumn(name="student_id")
//    private Set<Student> students = new HashSet<>();

    public Course() {
        super();
    }

    public Course(String name, int duration, int auditorium, int idTeacher) {
        super();
        this.name = name;
        this.duration = duration;
        this.auditorium = auditorium;
       this.idTeacher = idTeacher;

    }


    @Override
    public String toString() {
        return "Course [name=" + name + ", duration=" + duration + ", auditorium=" + auditorium + ", idTeacher=" + idTeacher + "]";
    }

}