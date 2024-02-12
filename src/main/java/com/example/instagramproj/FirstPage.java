package com.example.instagramproj;

import com.example.instagramproj.Controller.AccountController;
import com.example.instagramproj.model.Account;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class FirstPage implements Initializable {

    @FXML
    private Button login;


    @FXML
    private AnchorPane pane;

    @FXML
    private Button signup;
    public AccountController controller = new AccountController();
    public static Account account;

    public void signup() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Register");
        dialog.setHeaderText("set your username and password");
        ButtonType login = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(login, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("username");
        TextField password = new PasswordField();
        password.setPromptText("Name");
        TextField email = new TextField();
        email.setPromptText("email");
        TextField name = new TextField();
        name.setPromptText("name");


        grid.add(new Label("username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("password:"), 0, 1);
        grid.add(password, 1, 1);
        grid.add(new Label("email: "),0,2);
        grid.add(email,1,2);
        grid.add(new Label("name: "),0,3);
        grid.add(name,1,3);




        Node loginButton = dialog.getDialogPane().lookupButton(login);
        loginButton.setDisable(true);
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);
        Platform.runLater(() -> username.requestFocus());
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == login) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });
        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(usernamePassword -> {
            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
            ;
            account = controller.signupEmail(username.getText(),password.getText(),name.getText(),email.getText());

        });
    }

    // login has some mistakes

    /*public void login(){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Register");
        dialog.setHeaderText("set your username and password");
        ButtonType login = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(login, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("username");
        TextField password = new PasswordField();
        password.setPromptText("Password");
        Button button = new Button("login with your email");

        Label l1 = new Label("username:");
        Label l2 = new Label("password:");
        Label l3 = new Label("forget password:");

        grid.add(l1, 0, 0);
        grid.add(username, 1, 0);
        grid.add(l2, 0, 1);
        grid.add(password, 1, 1);
        grid.add(l3,0,2);
        grid.add(button,1,2);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                grid.getChildren().removeAll(username,password,l1,l2,l3,button);

                TextField email = new TextField();
                email.setPromptText("email");
                grid.add(new Label("email"),0,0);
                grid.add(email,1,0);

                Button btn = new Button("Ok");
                grid.add(btn,2,0);

                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Dialog<Pair<String, String>> dialog1 = new Dialog<>();
                        dialog1.setTitle("Register");
                        dialog1.setHeaderText("set your username and password");
                        ButtonType login1 = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                        dialog1.getDialogPane().getButtonTypes().addAll(login1, ButtonType.CANCEL);
                        TextField newPass = new TextField();
                        newPass.setPromptText("password");
                        grid.add(newPass,1,1);

                        Node loginButton1 = dialog1.getDialogPane().lookupButton(login);
                        loginButton1.setDisable(true);
                        email.textProperty().addListener((observable, oldValue, newValue) -> {
                            loginButton1.setDisable(newValue.trim().isEmpty());
                        });

                        dialog1.getDialogPane().setContent(grid);
                        Platform.runLater(() -> email.requestFocus());
                        dialog1.setResultConverter(dialogButton1 -> {
                            if (dialogButton1 == login) {
                                return new Pair<>(email.getText(), newPass.getText());
                            }
                            return null;
                        });
                        Optional<Pair<String, String>> result1 = dialog1.showAndWait();
                        result1.ifPresent(usernamePassword -> {


                            account = controller.login(email.getText(), newPass.getText());

                        });
                    }
                });

            }
        });



        if (grid.getChildren().contains(username)){
            Node loginButton = dialog.getDialogPane().lookupButton(login);
            loginButton.setDisable(true);
            username.textProperty().addListener((observable, oldValue, newValue) -> {
                loginButton.setDisable(newValue.trim().isEmpty());
            });

            dialog.getDialogPane().setContent(grid);
            Platform.runLater(() -> username.requestFocus());
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == login) {
                    return new Pair<>(username.getText(), password.getText());
                }
                return null;
            });
            Optional<Pair<String, String>> result = dialog.showAndWait();
            result.ifPresent(usernamePassword -> {
                System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
                ;
                account = controller.login(username.getText(), password.getText());

            });
        }





    }*/
    public void setSignup(ActionEvent e) throws IOException {
        signup();
        FXMLLoader fxmlLoader = new FXMLLoader(InstagramApplication.class.getResource("accountPage.fxml"));
        AccountPage.account = new Account("Asoo","Asoo","Asoo",123);
        Account ac1 = new Account("Mahshad","Mahshad","Mahshad",12222);
        AccountPage.account.getFollowers().add(ac1);
        ac1.getFollowing().add(AccountPage.account);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    public void setLogin(ActionEvent actionEvent) {
        //login();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pane.setBackground(new Background(Collections.singletonList(new BackgroundFill(
                Color.WHITE,
                new CornerRadii(500),
                new Insets(10))),
                Collections.singletonList(new BackgroundImage(
                        new Image("img_1.png", 1504, 1128, false, true),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT))));

        signup.setCursor(Cursor.HAND);
        login.setCursor(Cursor.HAND);



    }



}
