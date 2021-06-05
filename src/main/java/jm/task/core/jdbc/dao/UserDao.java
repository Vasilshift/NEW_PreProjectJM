package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.Entity.table10;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void createUsersTable() throws SQLException;

    void dropUsersTable() throws SQLException;

    void saveUser(String name, String lastName, byte age) throws SQLException;

    void removeUserById(long id) throws SQLException;

    List<table10> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException;
}
