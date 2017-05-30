package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.RoleDAO;
import by.pvt.medvedeva.education.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Anastasiya Medvedeva
 */
@Repository
public class RoleDAOImpl extends AbstractDAO<Role> implements RoleDAO {

    @Autowired
    private RoleDAOImpl(SessionFactory sessionFactory) {
        super(Role.class, sessionFactory);
    }

}
