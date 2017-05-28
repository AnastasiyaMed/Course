package by.pvt.medvedeva.education.controller;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Role;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.interfaces.RoleService;
import by.pvt.medvedeva.education.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@Controller
@RequestMapping("/")
public class MainController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public MainController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "")
    public String showMainPage() {
        return "about";
    }

    @GetMapping(value = "about")
    public String showAboutPage() {
        return "about";
    }

    @GetMapping(value = "login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("login", "user", new User());
    }

    @GetMapping(value = "logout")
    public String doLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping(value = "register")
    public ModelAndView showRegisterPage() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("user");
            modelAndView.addObject("user", new User());
            List<Role> roles = roleService.getAll();
            modelAndView.addObject("roles", roles);
        } catch (DAOException e) {
            return new ModelAndView("error", "message", e.getMessage());
        }
        return modelAndView;
    }

    @PostMapping(value = "register")
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam(name = "role_id") Long roleId, Model model) {
        String page = null;
        if (result.hasErrors()) {
            List<ObjectError> objectErrors = result.getAllErrors();
            model.addAttribute("loginClass", "has-success");
            model.addAttribute("passwordClass", "has-success");
            model.addAttribute("nameClass", "has-success");
            model.addAttribute("surnameClass", "has-success");
            for (ObjectError error : objectErrors) {
                String errorString = error.toString();
                if (errorString.contains("login")) { model.addAttribute("loginClass", "has-error"); }
                if (errorString.contains("password")) { model.addAttribute("passwordClass", "has-error"); }
                if (errorString.contains("firstName")) { model.addAttribute("nameClass", "has-error"); }
                if (errorString.contains("lastName")) { model.addAttribute("surnameClass", "has-error"); }
                List<Role> roles;
                try {
                    roles = roleService.getAll();
                } catch (DAOException e) {
                    model.addAttribute("message", e.getMessage());
                    return "error";
                }
                model.addAttribute("roles", roles);
                page = "user";
            }
        } else {
            try {
                Role role = roleService.getById(roleId);
                user.setRole(role);
                userService.create(user);
                page = "redirect:/";
            } catch (DAOException e) {
                model.addAttribute("loginClass", "has-error");
                model.addAttribute("error", "userexist");
                page = "user";
            }
        }
        return page;
    }

    @GetMapping(value = "denied")
    public String accessDenied() {
        return "denied";
    }
}
