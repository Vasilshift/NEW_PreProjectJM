package jm.task.core.jdbc.service;
//package jm.task.core.jdbc.model;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userdao = new UserDaoJDBCImpl();
    public void createUsersTable() throws SQLException {
        userdao.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userdao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userdao.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) throws SQLException {
        userdao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        userdao.cleanUsersTable();
    }
}
