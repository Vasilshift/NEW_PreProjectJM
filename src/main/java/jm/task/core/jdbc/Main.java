package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.*;
//Work variant. Add .close()   16/06/21  18-50
public class Main {

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Tik", "Ernom", (byte) 45);
        userService.saveUser("Rik", "Kilon", (byte) 89);
        userService.saveUser("Sam", "Nikon", (byte) 12);
        userService.saveUser("Rom", "Polen", (byte) 34);
        userService.getAllUsers();
        userService.cleanUsersTable();
    }
}

