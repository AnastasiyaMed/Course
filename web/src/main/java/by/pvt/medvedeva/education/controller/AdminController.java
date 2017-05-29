package by.pvt.medvedeva.education.controller;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.interfaces.CourseService;
import by.pvt.medvedeva.education.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

}