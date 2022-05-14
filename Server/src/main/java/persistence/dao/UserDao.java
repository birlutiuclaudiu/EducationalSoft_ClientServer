package persistence.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import persistence.DataBaseSession;
import persistence.entities.User;

public class UserDao extends AbstractDao<User> {

    public UserDao() {

    }

    public User findByUsernameAndPassword(String username, String password) {
        DataBaseSession dataBaseSession = DataBaseSession.getInstance();
        Session session = dataBaseSession.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from User where username=:username and password=:password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            User user = (User) query.uniqueResult();
            transaction.commit();
            return user;
        } catch (HibernateException exc) {
            System.out.println(exc.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public User findByUsername(String username) {
        DataBaseSession dataBaseSession = DataBaseSession.getInstance();
        Session session = dataBaseSession.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from User where username=:username");
            query.setParameter("username", username);
            User user = (User) query.uniqueResult();
            transaction.commit();
            return user;
        } catch (HibernateException exc) {
            System.out.println(exc.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

}
