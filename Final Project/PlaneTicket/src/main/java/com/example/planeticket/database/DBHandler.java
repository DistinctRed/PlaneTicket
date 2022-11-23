package com.example.planeticket.database;

import com.example.planeticket.model.contact;
import com.example.planeticket.model.tickets;
import com.example.planeticket.model.users;

import java.sql.*;

public class DBHandler extends Config {

    Connection dbConnection;

    public Connection getDbConnection() throws SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }

public void signingUp(users user) {
        String query = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + ") VALUES(?,?,?,?)";

    try {
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setString(1, user.getFirstname());
        preparedStatement.setString(2, user.getLastname());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());

        preparedStatement.executeUpdate();


    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}

public void contactUp(contact contacts) {
        String query = "INSERT INTO " + Const.CONTACT_TABLE + "(" + Const.CONTACT_USERNAME + "," + Const.CONTACT_MESSAGE + ") VALUES(?,?)";

    try {
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setString(1, contacts.getUsercontact());
        preparedStatement.setString(2, contacts.getMessage());

        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}

public ResultSet loggingIn(users user) {
        ResultSet resultSet = null;

            String query = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_USERNAME + "=?" + " AND " + Const.USERS_PASSWORD + "=?";

    try {
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());

        resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }



    return resultSet;
}

// Philippines
public void addPhilippineTicket(int userId){ //putting the assigned userId appropriate to the one that logged in.
        String query = "INSERT INTO " + Const.TICKETS_TABLE + "(" + Const.TICKETS_IDUSER + "," + Const.TICKETS_TICKETNAME + ") VALUES(?,?)";

    try {
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setInt(1, userId); //putting the assigned userId appropriate to the one that logged in.
        preparedStatement.setString(2, "Philippine Ticket");

        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}

public void removePhilippineTicket(int userId) {
        String query = "DELETE FROM " + Const.TICKETS_TABLE + " WHERE " + Const.TICKETS_IDUSER + "=? AND " + Const.TICKETS_TICKETNAME + "=?";

    try {
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, "Philippine Ticket");
        preparedStatement.execute();
        preparedStatement.close();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}

    // China
    public void addChinaTicket(int userId){ //putting the assigned userId appropriate to the one that logged in.
        String query = "INSERT INTO " + Const.TICKETS_TABLE + "(" + Const.TICKETS_IDUSER + "," + Const.TICKETS_TICKETNAME + ") VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, userId); //putting the assigned userId appropriate to the one that logged in.
            preparedStatement.setString(2, "China Ticket");

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeChinaTicket(int userId) {
        String query = "DELETE FROM " + Const.TICKETS_TABLE + " WHERE " + Const.TICKETS_IDUSER + "=? AND " + Const.TICKETS_TICKETNAME + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, "China Ticket");
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Japan
    public void addJapanTicket(int userId){ //putting the assigned userId appropriate to the one that logged in.
        String query = "INSERT INTO " + Const.TICKETS_TABLE + "(" + Const.TICKETS_IDUSER + "," + Const.TICKETS_TICKETNAME + ") VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, userId); //putting the assigned userId appropriate to the one that logged in.
            preparedStatement.setString(2, "Japan Ticket");

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeJapanTicket(int userId) {
        String query = "DELETE FROM " + Const.TICKETS_TABLE + " WHERE " + Const.TICKETS_IDUSER + "=? AND " + Const.TICKETS_TICKETNAME + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, "Japan Ticket");
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int countingTotalTickets(int userId){
        String query = "SELECT COUNT(*) FROM " + Const.TICKETS_TABLE + " WHERE " + Const.TICKETS_IDUSER + "=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return resultSet.getInt(1);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return (0);

    }




}
