package jm.task.core.jdbc;
import java.sql.Statement;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import jm.task.core.jdbc.util.Util;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        SessionFactory sessionFactory = Util.getSessionFactory();
        Session session = Util.getSessionFactory().openSession();

//        for (User user : new UserDaoHibernateImpl().getAllUsers()
//             ) {
//            System.out.println("users from table: " + user.getName());
//        }



    }

}

