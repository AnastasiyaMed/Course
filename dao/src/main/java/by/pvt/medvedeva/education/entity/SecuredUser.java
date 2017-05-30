package by.pvt.medvedeva.education.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Anastasiya Medvedeva
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecuredUser implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private String nickName;
    private String fullName;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private Collection<GrantedAuthority> authorities;

}
