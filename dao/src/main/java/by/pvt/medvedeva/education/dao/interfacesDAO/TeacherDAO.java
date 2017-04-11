/**
 * 
 */
package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.entity.User;

import java.io.IOException;

/**
 * @author Medvedeva Anastasiya
 *
 */
public interface TeacherDAO <Teacher>{

	Teacher initTeacher(User user) throws IOException;

	}
