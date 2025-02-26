package org.example;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet;
        try {
            connection =helper.getConnection();
            System.out.println("Bağlantı kuruldu.");
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM sakila.actor;");
            while (resultSet.next()){
                System.out.print(resultSet.getString("actor_id"));
                System.out.print(" "+resultSet.getString("first_name"));
                System.out.print(" "+resultSet.getString("last_name"));
                System.out.println();
            }
        } catch (SQLException exception) {
           helper.showErrorMessage(exception);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}