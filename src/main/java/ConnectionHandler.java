import com.mysql.jdbc.Driver;

import java.sql.*;

public class ConnectionHandler {
    private String host = "207.244.247.114:3306";
    private String port= "3306";
    private String user = "aklusa";
    private String password = "BromiumCalciumBrombieDextroseDiOxiCloride";
    private String dbname = "Development";
    private ResultSet resultSet = null;
    private ResultSet rsec = null;
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    public void tableCheck() throws SQLException {

        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://207.244.247.114:3306/" + dbname + "?"
                            + "user=" + user + "&password=" + password);
            System.out.println("Checking for missing sql table. Will be created if it is missing.");
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("CREATE table if not exists credits (UUID text, username text, usercreds text);");
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Profile Creation Failed Because of Internal Error");
            throw e;
        } finally {
            close();
        }
    }

    public void createProfile(String uuid, String username, int credits) throws Exception {

        System.out.println("Attempting to create profile now");
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://207.244.247.114:3306/"+dbname+"?"
                            + "user="+user+"&password="+password);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("INSERT INTO credits (UUID, username, usercreds) SELECT * FROM (SELECT '" + uuid + "', '" + username + "', '" + credits + "') AS tmp_name WHERE NOT EXISTS ( SELECT usercreds FROM credits WHERE uuid = '" + uuid + "');");
            preparedStatement.execute();
            System.out.println("Attempting to Create profile with UUID of " + uuid + ", username of " + username + " and " + credits + " credits");
        } catch (Exception e) {
            System.out.println("Profile Creation Failed Because of Internal Error");
            throw e;
        } finally {
            close();
        }
    }

    public void AddCreds(String uuid, int credits) throws Exception {
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://207.244.247.114:3306/"+dbname+"?"
                            + "user="+user+"&password="+password);
            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select usercreds from credits where uuid = '" + uuid + "'");
            int newcreds = 0;
            String newcred;
            while (resultSet.next()) {
                newcreds = credits + Integer.parseInt(resultSet.getString("usercreds")) ;
            }
            newcred = String.valueOf(newcreds);
            preparedStatement = connect.prepareStatement("update credits set usercreds = '" + newcred + "' where uuid = '" + uuid + "'");
            preparedStatement.execute();
            System.out.println("Updating credits to " + newcred);
        } catch (Exception e) {
            System.out.println("Command Failed Because of Internal Error");
            throw e;
        } finally {

            close();
        }
    }
    public void RemoveCreds(String uuid, int credits) throws Exception {
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://207.244.247.114:3306/"+dbname+"?"
                            + "user="+user+"&password="+password);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select usercreds from credits where uuid ='" + uuid + "'");
            int newcreds = 0;
            String newcr;
            while(resultSet.next()) {
                newcreds = Integer.parseInt(resultSet.getString("usercreds")) - credits;
            }
            newcr = String.valueOf(newcreds);
            preparedStatement = connect
                    .prepareStatement("update credits set usercreds = '" + newcr + "' where uuid = '" + uuid + "'");
            preparedStatement.execute();
            System.out.println("Updating credits to " + newcr);
            System.out.println("Processing Command");
        } catch (Exception e) {
            System.out.println("Command Failed Because of Internal Error");
            throw e;
        } finally {
            close();
        }

    }
    public void ReadCreds(String uuid) throws Exception {
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://207.244.247.114:3306/"+dbname+"?"
                            + "user="+user+"&password="+password);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select usercreds,username from credits where uuid='" + uuid + "'");
            while(resultSet.next()) {
                System.out.println(resultSet.getString("usercreds") + " credits in " +resultSet.getString("username") + "'s account");
            }
        } catch (Exception e) {
            System.out.println("Command Failed Because of Internal Error");
            throw e;
        } finally {
            close();
        }

    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}