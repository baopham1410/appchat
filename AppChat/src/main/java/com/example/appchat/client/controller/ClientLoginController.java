package com.example.appchat.client.controller;

import com.example.appchat.client.ClientApp;
import com.example.appchat.client.service.LoginUserService;
import com.example.appchat.model.User;
import com.example.appchat.utils.AlertHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class ClientLoginController {
    @FXML
    private PasswordField pwPassword;
    @FXML
    private TextField txtUsername;

    private final LoginUserService loginUserService;

    public ClientLoginController() {
        loginUserService = new LoginUserService();
    }

    public void onClickLogin(ActionEvent actionEvent) throws SQLException, IOException { // phuong thuc dieu khien nut login
        String username = txtUsername.getText();
        if (pwPassword.getText().isEmpty() || txtUsername.getText().isEmpty()) { // check null 2 o textbox
            AlertHelper.showAlert(Alert.AlertType.ERROR, "Error", null, "Username or Password is blank!");
            return;
        }
        User userLogin = new User(txtUsername.getText(), pwPassword.getText());
        if (!loginUserService.checkAccount(userLogin)) { // check tai khoan dung hay sai
            AlertHelper.showAlert(Alert.AlertType.ERROR, "Error", null, "Username or Password is uncorrected");
            return;
        }
        ChatController.setLbUsername(username);

        ClientApp.setRoot("/client/ChatFrm"); // dang nhap thanh cong thi chuyen man hinh
    }
}
