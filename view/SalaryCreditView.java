package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class SalaryCreditView {
    private TextField accountNumberField = new TextField();
    private TextField employerField = new TextField();
    private TextField amountField = new TextField();
    private Button submitButton = new Button("Credit Salary");
    private Button backButton = new Button("Back");
    private Label confirmationLabel = new Label();
    private Scene scene;

    public SalaryCreditView() {
        Label title = new Label("Credit Salary (Cheque Account)");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        accountNumberField.setPromptText("Cheque Account Number");
        employerField.setPromptText("Employer Name");
        amountField.setPromptText("Salary Amount (BWP)");

        VBox box = new VBox(12, title, accountNumberField, employerField, amountField, submitButton, backButton, confirmationLabel);
        box.setPadding(new Insets(20));
        this.scene = new Scene(box, 360, 340);
    }

    public Scene getScene() { return scene; }
    public String getAccountNumber() { return accountNumberField.getText(); }
    public String getEmployer() { return employerField.getText(); }
    public String getAmount() { return amountField.getText(); }
    public Button getSubmitButton() { return submitButton; }
    public Button getBackButton() { return backButton; }
    public void showConfirmation(String msg) { confirmationLabel.setText(msg); }
}

