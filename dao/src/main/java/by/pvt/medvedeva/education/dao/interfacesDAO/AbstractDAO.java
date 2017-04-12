package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbstractDAO<T extends Entity>  implements BaseDAO <T>{
    protected ConnectionPool connectionPool;
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;


}
