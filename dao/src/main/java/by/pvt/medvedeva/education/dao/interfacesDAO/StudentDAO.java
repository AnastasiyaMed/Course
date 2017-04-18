/**
 * 
 */
package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.entity.User;

/**
 * @author Medvedeva Anastasiya
 *
 */
public interface StudentDAO <Student> {


	Student initStudent(User user, int level, double average, int cardId);

	Student initStudentFromBD(User user);




}
