package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.*;
//Work variant. Rebuiided codestyle 07/06/21 19:05
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

