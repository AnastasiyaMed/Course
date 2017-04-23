/**
 * 
 */
package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.entity.User;

/**
 * @author Medvedeva Anastasiya
 *
 */
public interface TeacherDAO <Teacher>{


	Teacher initTeacher(User user);

	//Teacher initTeacherFromBD(int idTeacher) throws DAOException;


	}
