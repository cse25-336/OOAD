package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class RegisterCustomerView {
    private TextField firstNameField = new TextField();
    private TextField surnameField = new TextField();
    private TextField addressField = new TextField();
    private TextField phoneField = new TextField();
    private TextField usernameField = new TextField();
    private PasswordField pinField = new PasswordField();
    private CheckBox employedCheck = new CheckBox("Currently Employed?");
    private Button submitButton = new Button("Register");
    private Button backButton = new Button("Back to Login");
    private Label statusLabel = new Label();
    private Scene scene;

    public RegisterCustomerView() {
        Label title = new Label("Register Customer");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        firstNameField.setPromptText("First Name");
        surnameField.setPromptText("Surname");
        addressField.setPromptText("Address");
        phoneField.setPromptText("Phone");
        usernameField.setPromptText("Username");
        pinField.setPromptText("PIN");

        VBox box = new VBox(10, title, firstNameField, surnameField, addressField, phoneField, usernameField, pinField, employedCheck, submitButton, backButton, statusLabel);
        box.setPadding(new Insets(20));
        this.scene = new Scene(box, 360, 460);
    }

    public Scene getScene() { return scene; }
    public String getFirstName() { return firstNameField.getText(); }
    public String getSurname() { return surnameField.getText(); }
    public String getAddress() { return addressField.getText(); }
    public String getPhone() { return phoneField.getText(); }
    public String getUsername() { return usernameField.getText(); }
    public String getPin() { return pinField.getText(); }
    public boolean isEmployed() { return employedCheck.isSelected(); }
    public Button getSubmitButton() { return submitButton; }
    public Button getBackButton() { return backButton; }
    public void showConfirmation(String msg) { statusLabel.setText(msg); }
}
