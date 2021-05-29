package jm.task.core.jdbc;
import java.sql.Statement;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
//import jm.task.core.jdbc.util.Util;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //private static Util connect;
    //private static Statement statement;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Connection connection;

//        UserService userService = new UserServiceImpl();       //строка от Максима
//        userService.getAllUsers();                              //строка от Максима

//        Util connect = new Util();
//        connect
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        //userDaoJDBC.getAllUsers();

//        }
        //UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        //UserDaoJDBCImpl.dropUsersTable();
        //userDaoJDBC.createUsersTable();
        //UserDaoJDBCImpl.saveUser("Mike", "Fok", (byte) 25);
//        userDaoJDBC.saveUser("Rob", "Will", (byte) 45);
//        userDaoJDBC.saveUser("Nik", "Cave", (byte) 56);
//        userDaoJDBC.saveUser("Pole", "Alen", (byte) 65);
        //userDaoJDBC.getAllUsers();








    }

}

