
package by.pvt.medvedeva.education.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * @author Anastasiya Medvedeva
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table (name = "courses")
public class Course extends Pojo {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "{course.name.notblank}")
    @Size(min = 3, max = 30, message = "{course.name.size}")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s ]+$", message = "{course.name.pattern}")
    @Column (name = "name")
     private String name;

    @NotBlank(message = "{course.duration.notblank}")
    @Size(min = 1, max = 6, message = "{course.duration.size}")
    @Pattern(regexp = "^[0-9]+$", message = "{course.duration.pattern}")
    @Column (name = "duration")
    private Integer duration;

    @NotBlank(message = "{course.auditorium.notblank}")
    @Size(min = 1, max = 6, message = "{course.auditorium.size}")
    @Pattern(regexp = "^[0-9]+$", message = "{course.auditorium.pattern}")
    @Column (name = "auditorium")
    private Integer auditorium;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}