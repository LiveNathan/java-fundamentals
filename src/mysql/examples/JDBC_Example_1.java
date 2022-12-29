package mysql.examples;

import java.sql.*;

// NOTE: This is more or less a copy of the example shown here on the platform
// here: https://platform.codingnomads.co/learn/mod/page/view.php?id=2132

public class JDBC_Example_1 {


    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;

        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost/university?"
                    + "user=root&password=PASSWORD"
                    + "&useSSL=false&allowPublicKeyRetrieval=true";

            // Setup the connection with the DB
            connection = DriverManager
                    .getConnection(connectionString);

            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from university.courses");


            // loop through the result set while there are more records
            while (resultSet.next()) {

                // get the id, name and units fields from the result set and assign them to local variables
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int units = resultSet.getInt("credits");

                // print out the result
                System.out.println("Course ID: " + id + " is " + name + " and has " + units + units);
            }
//            int x = statement.executeUpdate("INSERT INTO university.courses (name, credits) VALUES ('geology', 3)");
//            int x = statement.executeUpdate("UPDATE university.courses set credits = 4 where name = 'geology'");
//            int x = statement.executeUpdate("DELETE from university.courses where id = 1");

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Exception occured - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                // close all JDBC elements
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}