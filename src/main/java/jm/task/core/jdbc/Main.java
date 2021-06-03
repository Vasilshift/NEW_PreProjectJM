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
//****************************work code******************************************
//        Connection connection = Util.getConnection();
//
//        UserService userService = new UserServiceImpl();
//
//        userService.dropUsersTable();
//        userService.createUsersTable();
//************************************************************************

//        userService.saveUser("Tik", "Ernom", (byte) 45);
//        userService.saveUser("Rik", "Kilon", (byte) 89);
//        userService.saveUser("Sam", "Nikon", (byte) 12);
//        userService.saveUser("Rom", "Polen", (byte) 34);
//

        Connection connection = Util.getConnection();
        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();

//        try {
//            connection = Util.getConnection();
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("INSERT INTO test.table10 (name, lastName, age  ) VALUES (" + "Rick" + "," + "Noi" + "," +
//            45 + ");");
//        } catch (Exception e ) {
//            e.printStackTrace();
//        }



//        Statement statement;
//        //Connection connection = null;
//        //Util connect = new Util();
//        PreparedStatement preparedStatement;

//
//        userService.getAllUsers();



    }

}

