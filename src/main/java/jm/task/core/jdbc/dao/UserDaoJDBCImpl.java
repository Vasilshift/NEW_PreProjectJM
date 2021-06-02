package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    private Statement statement;
    private Connection connection;
    //Util connect = new Util();
    PreparedStatement preparedStatement;

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() throws SQLException {
        //Connection connection = null;

        try {
            connection = Util.getConnection();
            String query = "CREATE TABLE IF NOT EXISTS test.table10 (\n" +
                    " `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    " `name` VARCHAR(45) NULL,\n" +
                    " `lastName` VARCHAR(45) NULL,\n" +
                    " `age` TINYINT NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            //ResultSet resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    public void dropUsersTable() throws SQLException {
            try {
                connection = Util.getConnection();
                statement = connection.createStatement();
                statement.execute("DROP TABLE IF EXISTS test.table10;");
                //statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {

        try {
//            connection = Util.getConnection();
//            String query = "INSERT INTO test.table10 (name, lastName, age  ) VALUES (?,?,?);";
//            statement = connection.createStatement();
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);

            //**************************************************
            connection = Util.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO test.table10 (name, lastName, age  ) VALUES ("+name+ "," +lastName+ "," +
                    age+");");

            //**************************************************

            //preparedStatement.execute(query);
            System.out.printf("Пользователь с именем %s добавлен в базу данных.", name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) throws SQLException{
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            statement.execute("delete from test.table10 where id = " +id+ ");");
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
            System.out.printf("Пользователь с id %d удалён из базы данных.\n", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException{
        List<User> list = new ArrayList<>();
        //String query = "SELECT * FROM test.table10;";
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            //statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.table10;");
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
        String query = "DELETE FROM test.table10;";
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            statement.execute("DELETE FROM test.table10;");
            System.out.println("Таблица очищена.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}