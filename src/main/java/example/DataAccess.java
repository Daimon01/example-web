package example;

import java.sql.*;
import java.util.ArrayList;

public class DataAccess {
    public ArrayList<String> LoadList() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "postgres");
        Statement state = connect.createStatement();
        ResultSet res = state.executeQuery("select name from example");
        res.next();
        String temp = res.getString("name");
        ArrayList<String> list = new ArrayList<>();
        list.add(temp);
        list.add(res.getString("name"));
        return list;
    }

    public boolean getUser(String user) throws SQLException {
        String userID = user;
        Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "123");
        PreparedStatement state = connect.prepareStatement("select id from Users where Users.id = ?");
        state.setString(1, userID);
        ResultSet res = state.executeQuery();
        boolean temp = res.next();
        state.close();
        connect.close();
        return temp;
    }

    public void createUser(String user, String Pass) throws SQLException {
        String userID = user;
        String newPass = Pass;
        Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "123");
        PreparedStatement state = connect.prepareStatement("insert into users (id, password) values (?, ?)");
        state.setString(1, userID);
        state.setString(2, newPass);
        state.execute();
        state.close();
        connect.close();
    }

    public ArrayList<String> getAllUser() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "123");
        PreparedStatement state = connect.prepareStatement("select id from Users");
        ResultSet res = state.executeQuery();
        ArrayList<String> list = new ArrayList<>();

        while (res.next()) {
            list.add(res.getString("id"));
        }
        state.close();
        connect.close();
        return list;
    }
}
