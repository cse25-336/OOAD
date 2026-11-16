package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class DepositView {
    private TextField accountNumberField = new TextField();
    private TextField amountField = new TextField();
    private Button submitButton = new Button("Deposit");
    private Button backButton = new Button("Back");
    private Label receiptLabel = new Label();
    private Scene scene;

    public DepositView() {
        Label title = new Label("Deposit Funds");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        accountNumberField.setPromptText("Account Number");
        amountField.setPromptText("Amount (BWP)");

        VBox box = new VBox(12, title, accountNumberField, amountField, submitButton, backButton, receiptLabel);
        box.setPadding(new Insets(20));
        this.scene = new Scene(box, 350, 300);
    }

    public Scene getScene() { return scene; }
    public String getAccountNumber() { return accountNumberField.getText(); }
    public String getAmount() { return amountField.getText(); }
    public Button getSubmitButton() { return submitButton; }
    public Button getBackButton() { return backButton; }
    public void showReceipt(String msg) { receiptLabel.setText(msg); }
}
