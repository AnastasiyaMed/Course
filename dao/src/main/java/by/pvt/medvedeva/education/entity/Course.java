
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

    @Column (name = "name")
     private String name;

    @Column (name = "duration")
    private Integer duration;

    @Column (name = "auditorium")
    private Integer auditorium;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}