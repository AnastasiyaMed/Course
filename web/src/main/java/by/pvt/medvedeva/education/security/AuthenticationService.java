package by.pvt.medvedeva.education.security;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Role;
import by.pvt.medvedeva.education.entity.SecuredUser;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@Service("authenticationService")
public class AuthenticationService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public AuthenticationService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user;
        SecuredUser securedUser;
        try {
            user = userService.getByLogin(login);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            securedUser = new SecuredUser(
                    user.getId(),
                    user.getFirstName(),
                    user.getPassword(),
                    "nickname",
                    user.getFirstName().concat(" ").concat(user.getLastName()),
                    true,
                    true,
                    true,
                    true,
                    setAuthorities(user.getRole())
            );
        } catch (DAOException e) {
            throw new UsernameNotFoundException("User not found");
        }
        return securedUser;
    }

    private Collection<GrantedAuthority> setAuthorities(Role role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        switch (role.getName()) {
            case "TEACHER":
                authorities.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
                break;
            case "ADMIN":
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                break;
            default:
                authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
                break;
        }
        return authorities;
    }
}
