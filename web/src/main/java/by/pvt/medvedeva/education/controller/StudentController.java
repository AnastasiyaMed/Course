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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@Controller
@RequestMapping("/student")
public class StudentController {
private final static int DEFAULT_PAGE = 1;
    private final static int COUNT_PAGE = 2;
    private final CourseService courseService;
    private final UserService userService;

    @Autowired
    public StudentController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping(value = {"", "page/{page}"})
    public ModelAndView showStudentPage(ModelAndView modelAndView, /*HttpSession session, */ @PathVariable(required = false)  Integer page) {
          try {
            int pageNumber;
            if (page != null) {
                pageNumber = page;
            } else {
                pageNumber = DEFAULT_PAGE;
            }
            int pageCapacity = COUNT_PAGE;
            List<Course> courses = courseService.getCoursesByPage(pageNumber, pageCapacity);
            int courseCount = courseService.getCoursesCount();
                    modelAndView.setViewName("student");
            modelAndView.addObject("courses", courses);
            modelAndView.addObject("pageNumber", pageNumber);
            modelAndView.addObject("pageCapacity", pageCapacity);
            modelAndView.addObject("courseCount", courseCount);
            SecuredUser securedUser = (SecuredUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<Course> userCourses = userService.getById(securedUser.getId()).getCourses();

            modelAndView.addObject("userCourses", userCourses);
        } catch (DAOException e) {
            return new ModelAndView("error", "message", e.getMessage());
        }
        return modelAndView;
    }

    @GetMapping("/course/add/{id}")
    public String joinCourse(@PathVariable Long id) {
        try {
            Course course = courseService.getById(id);
            SecuredUser securedUser = (SecuredUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userService.getById(securedUser.getId());
            user.getCourses().add(course);
            userService.update(user);
        } catch (DAOException e) {
            return "error";
        }
        return "redirect:/student";
    }

    @GetMapping("/course/remove/{id}")
    public String leaveCourse(@PathVariable Long id) {
        try {
            Course course = courseService.getById(id);
            SecuredUser securedUser = (SecuredUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userService.getById(securedUser.getId());

            List<Course> newList = new ArrayList<>();
            for (Course c : user.getCourses()) {
                if (!(c.getId().equals(course.getId()))) {
                    newList.add(c);
                }
            }
            user.setCourses(newList);
            userService.update(user);
        } catch (DAOException e) {
            return "error";
        }
        return "redirect:/student";
    }

}
