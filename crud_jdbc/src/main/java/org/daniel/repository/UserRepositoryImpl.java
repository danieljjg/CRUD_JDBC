package org.daniel.repository;

import org.daniel.database.DatabaseConnection;
import org.daniel.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRespository{

    Connection connection;

    public UserRepositoryImpl() {

        try{
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }


    @Override
    public List<User> findAll() {


        List<User> users = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {

            try(ResultSet resultSet = statement.executeQuery("select * from usuarios");) {

                while(resultSet.next()) {

                    users.add(getUser(resultSet));

                }

                return users;
            } catch (SQLException e){
                e.printStackTrace();
            }


        }catch (SQLException sex) {

            sex.printStackTrace();

        }

        return null;
    }


    @Override
    public User findById(Long id) {

        User user = null;
        String query = "SELECT * FROM usuarios WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery()){

                while(resultSet.next()){

                    return getUser(resultSet);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    @Override
    public void addUser(User user) {

        String query = "INSERT INTO usuarios (username, password, email) VALUES (?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean deleteUser(Long id) {

        String query = "DELETE FROM USUARIOS WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean modifyUser(Long id) {
        return false;
    }

    private static User getUser(ResultSet resultSet) throws SQLException {


            User user = new User();

            user.setId(resultSet.getLong("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));

            return user;

    }

}
