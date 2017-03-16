/**
 * 
 */
package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;

/**
 * @author Medvedeva Anastasiya
 *
 */
public interface StudentDAO {


	Student initStudent(User user);

	void addStudent(Student student);


}
