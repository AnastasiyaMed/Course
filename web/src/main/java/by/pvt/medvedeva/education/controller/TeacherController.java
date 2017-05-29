package by.pvt.medvedeva.education.controller;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.SecuredUser;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.interfaces.CourseService;
import by.pvt.medvedeva.education.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/teacher")
public class TeacherController {

    private final CourseService courseService;
    private final UserService userService;

    @Autowired
    public TeacherController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }


    @GetMapping("")
    public ModelAndView showTeacherPage() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("teacher");
            List<Course> allCourses = courseService.getAll();
            SecuredUser securedUser = (SecuredUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userService.getById(securedUser.getId());

            List<Course> teacherCourses = new ArrayList<>();

            for (Course c : allCourses) {
                if ((c.getUser()!=null)&&(c.getUser().getId().equals(user.getId()))) {
                    teacherCourses.add(c);
                }
            }
            modelAndView.addObject("teacherCourses", teacherCourses);
            return modelAndView;
        } catch (DAOException e) {
            return new ModelAndView("error", "message", e.getMessage());
        }
    }

}
