package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractService {
    protected HibernateUtil util = HibernateUtil.getHibernateUtil();
    protected Session session;
    protected Transaction transaction;
    protected static boolean flag;


    public Transaction getTransaction () {
        if (flag == false) {
            transaction = session.beginTransaction();
            flag = true;
        } else {
            transaction = session.getTransaction();
        }
        return transaction;
    }

    public void commitTransaction(){
        if (flag == false) {
            transaction.commit();
        }
    }
}
