package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimeZone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if(!connection.isClosed()){
                System.out.println("Соединение с БД установлено.");
            }
        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвера.");
        }
//        finally {
//            try {
//                connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return connection;
    }

//    public static Statement getStatement(){
//        Connection connection = getConnection();
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return statement;
//    }
//
//    public static PreparedStatement getPrStatement(String sql){
//        Connection connection = getConnection();
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement(sql);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return statement;
//    }
}