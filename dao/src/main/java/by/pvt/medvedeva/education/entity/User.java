
package by.pvt.medvedeva.education.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class User extends Pojo {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "{user.firstName.notblank}")
    @Size(min = 2, max = 20, message = "{user.firstName.size}")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "{user.firstName.pattern}")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "{user.surname.notblank}")
    @Size(min = 2, max = 20, message = "{user.surname.size}")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я-/s]+$", message = "{user.surname.pattern}")
    private String lastName;

    @Column(name = "login", unique = true)
    @NotBlank(message = "{user.login.notblank}")
    @Size(min = 6, max = 20, message = "{user.login.size}")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9]+$", message = "{user.login.pattern}")
    private String login;

    @Column(name = "password")
    @NotBlank(message = "{user.password.notblank}")
    @Size(min = 8, max = 32, message = "{user.password.size}")
    private String password;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany
    @JoinTable(name = "users_has_courses",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Course> courses;

}
