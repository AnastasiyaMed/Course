package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.CourseDAOImpl;
import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CourseServiceTest {
    CourseService service = CourseService.getInstance();
    TeacherService teacherService = TeacherService.getInstance();
    UserService userService = UserService.getInstance();
    Teacher teacher;

    public CourseServiceTest() throws DAOException {
    }

//    @Before
//    public void begin() throws Exception {
//        User user = new User(null, "Nik", "Nikiforov", "nini", "ninini", 0);
//        userService.create(user);
//        Teacher teacher = teacherService.initTeacher(user);
//        teacherService.create(teacher);
//    }

    @Test
    public void CourseServiceTest() throws Exception {
        List <Course> courses;

        Course course = new Course(null, "Psihology", 65, 414, teacher);
       /*
       * create() Method
       * */
        service.create(course);
          /*
       * getAll() Method
       * */
        courses = service.getAll();
        Course courseTest = new Course();
        for (Course c : courses) {
            if (c.getName().equals(course.getName())) {
                courseTest = c;
            }
        }
        CourseDAOImpl.getInstance().delete(course.getCourseId());
        Assert.assertEquals("Дисциплина не совпадает", course, courseTest);
    }



}