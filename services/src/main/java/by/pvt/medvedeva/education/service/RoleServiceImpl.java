package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.RoleDAO;
import by.pvt.medvedeva.education.entity.Role;
import by.pvt.medvedeva.education.service.interfaces.RoleService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Anastasiya Medvedeva
 */
@Service
@Log4j
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {

        @Autowired
        protected RoleServiceImpl(RoleDAO roleDAO) {
            super(roleDAO);
        }


}
