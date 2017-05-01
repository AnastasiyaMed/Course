package by.pvt.medvedeva.education.dao.exception;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Level;

/**
 *
 * @Author Anastasiya Medvedeva
 *
 * In this class described custom Exception, that give information about some trouble with acces to database to next level
 *
 */

@Log4j
public class DAOException extends Exception {
    /**
     * constructor
      * @param msg
     *
     */
    public DAOException(String msg) {
            super(msg);
        }
    /**
     * constructor
     * @param msg
     * @param e
     *
     */
        public DAOException(String msg, Throwable e) {
            super(msg, e);
        }
    /**
     * constructor
     * @param msg
     * @param e
     * @param clazz
     *
     */
        public DAOException(Class clazz, String msg, Throwable e) {
            super(msg, e);
            log.log(Level.ERROR, msg, e);
        }
}
