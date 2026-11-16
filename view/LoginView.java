package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class LoginView {
    private TextField usernameField = new TextField();
    private PasswordField pinField = new PasswordField();
    private Button loginButton = new Button("Login");
    private Button registerButton = new Button("Register New Customer");
    private Label messageLabel = new Label();
    private Scene scene;

    public LoginView() {
        Label title = new Label("Gaborone Bank - Login");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        usernameField.setPromptText("Username");
        pinField.setPromptText("PIN");
        loginButton.setMaxWidth(Double.MAX_VALUE);
        registerButton.setMaxWidth(Double.MAX_VALUE);

        VBox box = new VBox(12, title, usernameField, pinField, loginButton, registerButton, messageLabel);
        box.setPadding(new Insets(25));
        box.setAlignment(Pos.CENTER);
        this.scene = new Scene(box, 350, 320);
    }

    public Scene getScene() { return scene; }
    public String getUsername() { return usernameField.getText(); }
    public String getPin() { return pinField.getText(); }
    public Button getLoginButton() { return loginButton; }
    public Button getRegisterButton() { return registerButton; }
    public void showErrorMessage(String msg) { messageLabel.setText(msg); }
}
