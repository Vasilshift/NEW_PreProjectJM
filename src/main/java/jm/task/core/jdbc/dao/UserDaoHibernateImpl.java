package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.*;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.criteria.*;

public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory sessionFactory = Util.getSessionFactory();
    private Session session;
    //Transaction transaction = session.getTransaction();

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        try (Session session = sessionFactory.getCurrentSession();) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS test.User (`id` INT NOT NULL AUTO_INCREMENT," +
                    "                 `name` VARCHAR(45) NULL," +
                    "                 `lastName` VARCHAR(45) NULL," +
                    "                 `age` TINYINT NULL," +
                    "                  PRIMARY KEY (`id`));").
                    executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            if (session != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    session.getTransaction().rollback();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
            e.printStackTrace();
        }
        System.out.println("Table created!");
    }

    @Override
    public void dropUsersTable() {
        try (Session session = sessionFactory.getCurrentSession();) {
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS test.User;").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Table created!");
        } catch (Exception e) {
            if (session != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    session.getTransaction().rollback();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = sessionFactory.getCurrentSession();) {
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            session.getTransaction().commit();
            System.out.println("user added!");
        } catch (Exception e) {
            if (session != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    session.getTransaction().rollback();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    session.getTransaction().rollback();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
            e.printStackTrace();
        }
        System.out.println("user removed");
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<User> user = query.getResultList();
        return user;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery("TRUNCATE TABLE User;").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    session.getTransaction().rollback();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
            e.printStackTrace();
        }
        System.out.println("Table cleaned");
    }
}
