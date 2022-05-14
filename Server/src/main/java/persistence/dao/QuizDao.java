package persistence.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import persistence.DataBaseSession;
import persistence.entities.Quiz;
import persistence.entities.User;

import java.util.List;

public class QuizDao extends AbstractDao<Quiz> {

    public List<Quiz> getAllQuizzesByUser(User user) {
        DataBaseSession dataBaseSession = DataBaseSession.getInstance();
        Session session = dataBaseSession.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from Quiz where user=:user");
            query.setParameter("user", user);
            List quizzes = query.getResultList();
            transaction.commit();
            return quizzes;
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
