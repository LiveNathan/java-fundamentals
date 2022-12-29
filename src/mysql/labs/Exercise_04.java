package mysql.labs;

/*
 *  MySQL Exercise 4:
 *
 *   Now that you have mastered your air travel database, it's time to connect this DB to a Java application
 *   using JDBC. You can start simple here and build your way up. Within a Java application, using JDBC, please
 *   demonstrate how to:
 *
 *   Note: CRUD means (Create, Read, Update, Delete)
 *
 *       1. CRUD new flights
 *       2. CRUD new passengers
 *       3. Bonus: flex those JDBC muscles! How nice, clean, useful can you make this? Show us what you've got!
 *
 *   Caution: Before you push this code to GitHub, be sure to REMOVE or REPLACE your DATABASE PASSWORD. You do not
 *   want to push your database password to GitHub. If you do push your password to GitHub you'll need to delete
 *   the commit from your Git history. See, for instance: https://medium.com/multinetinventiv/removing-commits-from-git-history-4e2340288484
 *
 */

import java.math.BigInteger;
import java.sql.*;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise_04 {
    private static Connection connection = null;

    public static void main(String[] args) {
        // Load the MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Set up the connection with the DB
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/air_travel?" +
                    "user=root&password=" + System.getenv("PASSWORD") +"&useSSL=false");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Create object
        Exercise_04 exercise04 = new Exercise_04();
        // Create flight
        exercise04.createRandomFlight();
        // Query flight
        int idFlight = exercise04.queryCreatedFlight();
        // Update flight
        exercise04.updateFlight(idFlight);
        // Delete flight
        exercise04.deleteFlight(idFlight);
        // Create passenger
        exercise04.createRandomPassenger();
        // Query passenger
        int idPassenger = exercise04.queryCreatedPassenger();
        // Update passenger
        exercise04.updatePassenger(idPassenger);
        // Delete passenger
        exercise04.deletePassenger(idPassenger);
    }

    /* Create flight */
    public void createRandomFlight() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO air_travel.flights (plane, airline, origin, destination, depart, arrive) VALUES (?,?,?,?,?,?)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        // plane
        try {
            preparedStatement.setInt(1, random.nextInt(8 - 4 + 1) + 4); // (upperbound-lowerbound+1) + lowerbound
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // airline
        try {
            preparedStatement.setInt(2, random.nextInt(5 - 1 + 1) + 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // origin
        try {
            preparedStatement.setInt(3, random.nextInt(5 - 1 + 1) + 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // destination
        try {
            preparedStatement.setInt(4, random.nextInt(5 - 1 + 1) + 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // depart
        String[] dates = randomDateWithin1Year();
        try {
            preparedStatement.setString(5, dates[0]);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // arrive
        try {
            preparedStatement.setString(6, dates[1]);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // execute prepared statement
        try {
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("create flight rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] randomDateWithin1Year() {
        // Generate two random Instants on the timeline between two points
        Instant startInclusive = Instant.now().plus(Duration.ofDays(1));
        Instant endExclusive = Instant.now().plus(Duration.ofDays(365));
        long startSeconds = startInclusive.getEpochSecond();
        long endSeconds = endExclusive.getEpochSecond();
        Instant[] instants = new Instant[2];
        for (int i = 0; i < instants.length; i++) {
            long random = ThreadLocalRandom.current().nextLong(startSeconds, endSeconds);
            instants[i] = Instant.ofEpochSecond(random);
        }
        // Find the earlier Instant
        Instant instantArrive;
        Instant instantDepart;
        if (instants[0].compareTo(instants[1]) > 0) {
            instantArrive = instants[0];
            instantDepart = instants[1];
        } else {
            instantArrive = instants[1];
            instantDepart = instants[0];
        }

        // Convert to string
        final String PATTERN_FORMAT = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());
        String depart = formatter.format(instantDepart);
        String arrive = formatter.format(instantArrive);
        System.out.println("Departure: " + depart + ", Arrival: " + arrive);
        return new String[]{depart, arrive};
    }

    /* Query flight */
    public int queryCreatedFlight() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM air_travel.flights ORDER BY dateCreated DESC LIMIT 1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // print out results
        int idFlight = 0;
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                idFlight = resultSet.getInt("idFlight");
                System.out.println(idFlight);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getInt("plane"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getInt("airline"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getInt("origin"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getInt("destination"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getString("depart"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getString("arrive"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getString("dateCreated"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getString("dateModified"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return idFlight;
    }

    /* Update flight */
    public void updateFlight(int idFlight) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE air_travel.flights SET plane = ? WHERE idFlight = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        try {
            preparedStatement.setInt(1, random.nextInt(8 - 4 + 1) + 4); // (upperbound-lowerbound+1) + lowerbound
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement.setInt(2, idFlight);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // execute
        try {
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("update flight rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* Delete flight */
    public void deleteFlight(int idFlight) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE from air_travel.flights WHERE idFlight = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement.setInt(1, idFlight);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int rowsAffected = 0;
        try {
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("delete flight rows affected: " + rowsAffected);
    }

    /* Create passenger */
    public void createRandomPassenger() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO air_travel.passengers (firstName, lastName, email, phone) VALUES (?,?,?,?)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Generate random first and last name
        String[] passengerNameArray = new String[2];
        for (int i = 0; i < passengerNameArray.length; i++) {
            String name = BigInteger.probablePrime(100, new Random()).
                    toString(Character.MAX_RADIX).
                    replaceAll("[0-9]", "").
                    substring(0, 10);
            passengerNameArray[i] = name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        try {
            preparedStatement.setString(1, passengerNameArray[0]);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // last name
        try {
            preparedStatement.setString(2, passengerNameArray[1]);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // email from first and last name
        String passengerEmail = passengerNameArray[0] + "." + passengerNameArray[1] + "@gmail.com";
        try {
            preparedStatement.setString(3, passengerEmail.toLowerCase());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Generate random phone number
        Random random = new Random();
        int[] areacode = new int[3];
        for (int i = 0; i < areacode.length; i++) {
            areacode[i] = random.nextInt(8 - 1 + 1) + 1;
        }
        int i4 = random.nextInt(742);
        int i5 = random.nextInt(10000);
        String phoneNumber = String.format("%d%d%d-%03d-%04d", areacode[0], areacode[1], areacode[2], i4, i5);
        try {
            preparedStatement.setString(4, phoneNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // execute prepared statement
        try {
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("create passenger rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* Query passenger */
    public int queryCreatedPassenger() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM air_travel.passengers ORDER BY dateCreated DESC LIMIT 1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // print out results
        int idPassenger = 0;
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                idPassenger = resultSet.getInt("idPassenger");
                System.out.println(idPassenger);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getString("firstName"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getString("lastName"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getString("email"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(resultSet.getString("phone"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return idPassenger;
    }

    /* Update passenger */
    public void updatePassenger(int idPassenger) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE air_travel.passengers SET lastName = ? WHERE idPassenger = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement.setString(1, "Adams");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement.setInt(2, idPassenger);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // execute
        try {
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("update passenger rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* Delete passenger */
    public void deletePassenger(int idPassenger) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE from air_travel.passengers WHERE idPassenger = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement.setInt(1, idPassenger);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int rowsAffected = 0;
        try {
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("delete passenger rows affected: " + rowsAffected);
    }
}
