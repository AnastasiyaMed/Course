package by.pvt.medvedeva.education.service.interfaces;

import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;

public interface StudentService extends BaseService <Student>{

    Student initStudent(User user, int level, double average, int cardId);


}
