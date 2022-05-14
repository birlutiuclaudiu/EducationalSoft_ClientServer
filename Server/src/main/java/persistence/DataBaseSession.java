package persistence;

import lombok.Getter;
import lombok.Setter;
import org.flywaydb.core.Flyway;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import persistence.entities.Question;
import persistence.entities.Quiz;
import persistence.entities.QuizQuestion;
import persistence.entities.User;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
public class DataBaseSession {

    private static DataBaseSession single_instance = null;

    // Declaring a variable of type String
    private SessionFactory session;

    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private DataBaseSession() throws HibernateException {

        Map<String, String> settings = new HashMap<String, String>();
        settings.put("connection.driver_class", "org.postgresql.Driver");
        settings.put("dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        settings.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/educationalDB");
        settings.put("hibernate.connection.username", "postgres");
        settings.put("hibernate.connection.password", "postgres");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");
        settings.put("hibernate.hbm2ddl.auto", "update");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(User.class);
        metadataSources.addAnnotatedClass(Quiz.class);
        metadataSources.addAnnotatedClass(Question.class);
        metadataSources.addAnnotatedClass(QuizQuestion.class);
        Metadata metadata = metadataSources.buildMetadata();

        // here we build the SessionFactory (Hibernate 5.4)
        this.session = metadata.getSessionFactoryBuilder().build();
        Session session1 = session.openSession();
        session1.close();
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/educationalDB", "postgres", "postgres").baselineOnMigrate(true).load();

        flyway.migrate();

    }

    // Static method
    // Static method to create instance of Singleton class
    public static DataBaseSession getInstance() throws HibernateException {
        if (single_instance == null) single_instance = new DataBaseSession();
        return single_instance;
    }

}
