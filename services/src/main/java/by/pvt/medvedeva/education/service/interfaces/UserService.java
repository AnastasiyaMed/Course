package by.pvt.medvedeva.education.service.interfaces;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.User;

public interface UserService extends BaseService<User>{

    User getByLogin(String login) throws DAOException;
}
