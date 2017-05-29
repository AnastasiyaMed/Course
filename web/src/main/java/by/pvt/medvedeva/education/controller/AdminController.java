package by.pvt.medvedeva.education.controller;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.interfaces.CourseService;
import by.pvt.medvedeva.education.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CourseService courseService;
    private final UserService userService;


    @Autowired
    public AdminController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }


    @GetMapping("")
    public ModelAndView showStudentPage() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("admin");
            List<Course> courses = courseService.getAll();
            modelAndView.addObject("courses", courses);
            return modelAndView;
        } catch (DAOException e) {
            return new ModelAndView("error", "message", e.getMessage());
        }
    }


    @GetMapping(value = "/addCourse")
    public ModelAndView addCourse() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("course");
            modelAndView.addObject("course", new Course());
            List<User> users = userService.getAll();
            List<User> teachers = new ArrayList<>();

            for (User u : users) {
                if (u.getRole().getName().equals("TEACHER")) {
                    teachers.add(u);
                }
            }
            modelAndView.addObject("teachers", teachers);
            return modelAndView;
        } catch (DAOException e) {
            return new ModelAndView("error", "message", e.getMessage());
        }
    }

    @PostMapping(value = "/addCourse")
    public String doRegister(@Valid @ModelAttribute("course") Course course, BindingResult result, @RequestParam(name = "user_id") Long id, Model model) {
        String page = null;
        if (result.hasErrors()) {
            List<ObjectError> objectErrors = result.getAllErrors();
            model.addAttribute("nameClass", "has-success");
            model.addAttribute("durationClass", "has-success");
            model.addAttribute("auditoriumClass", "has-success");

            for (ObjectError error : objectErrors) {
                String errorString = error.toString();
                if (errorString.contains("name")) { model.addAttribute("nameClass", "has-error"); }
                if (errorString.contains("duration")) { model.addAttribute("durationClass", "has-error"); }
                if (errorString.contains("auditorium")) { model.addAttribute("auditoriumClass", "has-error"); }


                List<User> teachers = new ArrayList<>();
                try {

                    List<User> users = userService.getAll();
                    for (User u : users) {
                        if (u.getRole().getName().equals("TEACHER")) {
                            teachers.add(u);
                        }
                    }
                } catch (DAOException e) {
                    model.addAttribute("message", e.getMessage());
                    return "error";
                }
                model.addAttribute("teachers", teachers);
                page = "course";
            }
        } else {
            try {
                User user = userService.getById(id);
                course.setUser(user);
                courseService.create(course);
                page = "redirect:/admin";
            } catch (DAOException e) {
                model.addAttribute("nameClass", "has-error");
                model.addAttribute("error", "userexist");
                page = "course";
            }
        }
        return page;
    }

}