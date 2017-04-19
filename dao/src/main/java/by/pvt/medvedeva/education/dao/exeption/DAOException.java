package by.pvt.medvedeva.education.dao.exeption;


    public class DAOException extends Exception {
        public DAOException(String msg) {
            super(msg);
        }
        public DAOException(String msg, Throwable e) {
            super(msg, e);
        }
}
