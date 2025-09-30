package org.daniel;

import org.daniel.controllers.UserController;
import org.daniel.models.User;

import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        UserController userController = new UserController();

        userController.findAll().forEach(
                user -> System.out.println(user)
        );

        System.out.println("MOSTRAMOS UN USUARIO");
        System.out.println(userController.findById(6L));

        System.out.println("AÑADIMOS UN USUARIOS");
        userController.addUser(
                new User(
                        "Carlos",
                        "1234",
                        "josemi@xtart.com"
                )
        );


        userController.findAll().forEach(
                user -> System.out.println(user)
        );

        System.out.println("VAMOS A BORRAR UN USUARIO");
        userController.deleteUser(6L);

        userController.findAll().forEach(
                user -> System.out.println(user)
        );


    }
}