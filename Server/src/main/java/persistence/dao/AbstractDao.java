package persistence.dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import persistence.DataBaseSession;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDao<T> {
    /**
     * Camp ce reprezinta clasa obiectului ce extinde aceasta clasa generica
     */
    private final Class<T> type;

    /**
     * Constructor pentru clasa
     */
    public AbstractDao() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findById(Integer id) {
        DataBaseSession dataBaseSession = DataBaseSession.getInstance();
        Session session = dataBaseSession.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            T user = session.find(type, id);
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

    public List<T> getAll() {
        DataBaseSession dataBaseSession = DataBaseSession.getInstance();
        Session session = dataBaseSession.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from " + type.getSimpleName());
            List<T> data = query.getResultList();
            transaction.commit();
            return data;
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

    public Boolean save(T object) {
        DataBaseSession dataBaseSession = DataBaseSession.getInstance();
        Session session = dataBaseSession.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
            return true;
        } catch (HibernateException exc) {
            System.out.println(exc.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

}
