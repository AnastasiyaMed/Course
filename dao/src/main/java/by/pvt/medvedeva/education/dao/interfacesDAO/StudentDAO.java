/**
 *
 */
package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.entity.User;

/**
 * @author Medvedeva Anastasiya
 */
public interface StudentDAO<Student> {

    /**
     * @param user
     * @param level
     * @param average
     * @param cardId
     * @return
     */
    Student initStudent(User user, int level, double average, int cardId);


}
