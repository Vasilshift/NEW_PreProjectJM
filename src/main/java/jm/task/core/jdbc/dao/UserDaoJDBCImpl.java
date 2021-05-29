package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private Statement statement;
    private Connection connection = Util.getConnection();
    //Util connect = new Util();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() throws SQLException {
        //Connection connection = null;
        try {
            String query = "CREATE TABLE IF NOT EXISTS 'testx'.'table5' (\n" +
                    " `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    " `name` VARCHAR(45) NULL,\n" +
                    " `lastName` VARCHAR(45) NULL,\n" +
                    " `age` TINYINT NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery(query);

//            statement = connection.createStatement();
//            statement.addBatch("CREATE TABLE `testx`.`table2` (\n" +
//                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
//                    "  `name` VARCHAR(45) NULL,\n" +
//                    "  `lastName` VARCHAR(45) NULL,\n" +
//                    "  `age` TINYINT NULL,\n" +
//                    "  PRIMARY KEY (`id`));");
//            statement.executeBatch();
        } catch (Exception e) {}
    }
    public void dropUsersTable() throws SQLException {
        try {
            statement = connection.createStatement();
            statement.addBatch("DROP TABLE IF EXISTS testx.table5;");
            statement.executeBatch();
        } catch (Exception e) {e.printStackTrace();}
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {

        //connection.prepareStatement()
        //statement.execute(insert into test.users (name, lastName, age) values (name, lastName, age));

        try {
            Connection connection = null;
            statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into `testx`.`table5` (name, lastName, age)" +
                    " values (?,?,?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setLong(3, age);
            //int rows = preparedStatement.executeUpdate();
            //System.out.printf("%d rows added", rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void removeUserById(long id) throws SQLException {
//        statement = connection.createStatement();
//        //PreparedStatement preparedStatement = connection.prepareStatement(
//                "DELETE FROM `testx`.`table` WHERE id = ?;");
//        preparedStatement.setLong(1, id);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from `testx`.`table5` where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            System.out.printf("Пользователь с id %d удалён из базы данных.\n", id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers() throws SQLException {
        String query = "SELECT * FROM 'testx'.'table5';";
        List<User> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
                System.out.println(user);
            }
        } catch (Exception e) {e.printStackTrace();}
        return list;
    }

    public void cleanUsersTable() {
        String query = "DELETE FROM `testx`.`table5`;";
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery(query);

        } catch (Exception e) {e.printStackTrace();}



    }
}

