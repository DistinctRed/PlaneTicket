package com.example.planeticket.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.planeticket.database.DBHandler;
import com.example.planeticket.model.users;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpGotoButton;

    @FXML
    private Button contactGotoButton;

    public static int userId; //putting the assigned userId appropriate to the one that logged in.

    @FXML
    void initialize() {

        DBHandler dbHandler = new DBHandler();

        loginButton.setOnAction(actionEvent -> {
            users user = new users();
            user.setUsername(usernameTextField.getText().trim());
            user.setPassword(passwordTextField.getText().trim());

            ResultSet resultSet = dbHandler.loggingIn(user);

            try {
                if(resultSet != null && resultSet.next()) {
                    userId = resultSet.getInt("id"); //ResultSet is for being able to return info from the database. .getInt is to take an integer from a column, which is the "id" in this case.
                    //^putting the assigned userId appropriate to the one that logged in.
                    loginButton.getScene().getWindow().hide();

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/com/example/planeticket/menu.fxml"));

                    try {

                        fxmlLoader.load();

                    } catch(IOException e){
                        e.printStackTrace();
                    }

                    Parent root = fxmlLoader.getRoot();
                    Stage stage = new Stage();

                    Scene scene = new Scene(root);
                    stage.setScene(scene);

                    menuController MenuController = fxmlLoader.getController();
                    MenuController.setUsernameLabel(user); //this is for wanting to display the used username to log in on the menuController label (usernameLabel)





                    stage.show();



                } else {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/com/example/planeticket/loginError.fxml"));

                    try {

                        fxmlLoader.load();

                    } catch(IOException e){
                        e.printStackTrace();
                    }

                    Parent root = fxmlLoader.getRoot();
                    Stage stage = new Stage();

                    Scene scene = new Scene(root);
                    stage.setScene(scene);

                    loginErrorController loginerrorController = fxmlLoader.getController();



                    stage.show();

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        });

        signUpGotoButton.setOnAction(actionEvent -> {
            signUpGotoButton.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/planeticket/signup.fxml"));

            try {

                fxmlLoader.load();

            } catch(IOException e){
                e.printStackTrace();
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            signupController SignUpcontroller = fxmlLoader.getController();



            stage.show();

        });

        contactGotoButton.setOnAction(actionEvent -> {
            contactGotoButton.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/planeticket/contact.fxml"));

            try {

                fxmlLoader.load();

            } catch(IOException e){
                e.printStackTrace();
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            contactController ContactController = fxmlLoader.getController();



            stage.show();

        });


    }
}
