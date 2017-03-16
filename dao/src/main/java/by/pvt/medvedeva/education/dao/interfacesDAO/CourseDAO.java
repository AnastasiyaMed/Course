package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.entity.Course;

import java.util.List;

public interface CourseDAO {



	void addCourse(final Course course);

	List<Course> getAllCoursesInfo();


}
