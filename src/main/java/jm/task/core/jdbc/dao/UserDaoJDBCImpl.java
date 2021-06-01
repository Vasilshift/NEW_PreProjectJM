package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    //private Statement statement;
    //private Connection connection = Util.getConnection();
    //Util connect = new Util();
    PreparedStatement preparedStatement;
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() throws SQLException {
        //Connection connection = null;

            //Connection connection = Util.getConnection();

            try {
                Util.getStatement().execute("create table if not exists test.table10 (" +
                        "  `id` BIGINT not null AUTO_INCREMENT,\n" +
                        "  `name` varchar(45) null,\n" +
                        "  `lastName` varchar(45) null,\n" +
                        "  `age` TINYINT null,\n" +
                        "  primary key (`id`));");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public void dropUsersTable() throws SQLException {
            try {
                Util.getStatement().execute("DROP TABLE IF EXISTS test.table10;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {

        try {
            preparedStatement = Util.getPrStatement(
                    "INSERT INTO test.table10 (name, lastName, age  )" + " VALUES (?,?,?);");

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
            System.out.printf("Пользователь с именем %s добавлен в базу данных.", name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) throws SQLException{
        try {
            preparedStatement = Util.getPrStatement("delete from test.table10 where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.printf("Пользователь с id %d удалён из базы данных.\n", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException{
        List<User> list = new ArrayList<>();
        try {
            ResultSet resultSet = Util.getStatement().executeQuery("SELECT * FROM test.table10;");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try {
            Util.getStatement().execute("DELETE FROM test.table10;");
            System.out.println("Таблица очищена.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}