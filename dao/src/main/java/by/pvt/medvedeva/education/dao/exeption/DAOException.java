package by.pvt.medvedeva.education.dao.exeption;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class DAOException extends Exception {
        public DAOException(String msg) {
            super(msg);
        }
        public DAOException(String msg, Throwable e) {
            super(msg, e);
        }
        public DAOException(Class clazz, String msg, Throwable e) {
            super(msg, e);
            Logger logger = LogManager.getLogger(clazz);
            logger.log(Level.ERROR, msg, e);
        }
}
