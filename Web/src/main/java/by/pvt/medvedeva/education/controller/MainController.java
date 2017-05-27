package by.pvt.medvedeva.education.controller;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.interfaces.UserService;
import javafx.scene.control.Alert;
import org.hibernate.service.spi.ServiceException;
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
import java.util.Locale;

/**
 * @author Anastasiya Medvedeva
 */
@Controller
@RequestMapping("/")
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
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
        return new ModelAndView("user", "user", new User());
    }

    @PostMapping(value = "register")
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, Locale locale) {
        String page;
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
                if (errorString.contains("name")) { model.addAttribute("nameClass", "has-error"); }
                if (errorString.contains("surname")) { model.addAttribute("surnameClass", "has-error"); }
            }
            page = "user";
        } else {
            try {
                userService.create(user);
                page = "/";
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
