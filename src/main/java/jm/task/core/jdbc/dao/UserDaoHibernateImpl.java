package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.Entity.table10;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoHibernateImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {
        session.get(table10.class,1L);
    }

    @Override
    public List<table10> getAllUsers() {
        Session session = sessionFactory.openSession();


        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(table10.class);
        Root<table10> root = criteriaQuery.from(table10.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<table10> user = query.getResultList();
        session.close();
        return user;

    }

    @Override
    public void cleanUsersTable() {

    }
}
