package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class OpenAccountView {
    private ComboBox<String> accountTypeBox = new ComboBox<>();
    private TextField initialDepositField = new TextField();
    private TextField employerNameField = new TextField();
    private TextField employerAddressField = new TextField();
    private Button createButton = new Button("Open Account");
    private Button backButton = new Button("Back");
    private Label messageLabel = new Label();
    private Scene scene;

    public OpenAccountView() {
        Label title = new Label("Open New Account");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        accountTypeBox.getItems().addAll("Savings", "Investment", "Cheque");
        accountTypeBox.setPromptText("Select Account Type");
        initialDepositField.setPromptText("Initial Deposit (BWP)");
        employerNameField.setPromptText("Employer Name (Cheque only)");
        employerAddressField.setPromptText("Employer Address (Cheque only)");

        VBox box = new VBox(10, title, accountTypeBox, initialDepositField, employerNameField, employerAddressField, createButton, backButton, messageLabel);
        box.setPadding(new Insets(20));
        this.scene = new Scene(box, 360, 380);
    }

    public Scene getScene() { return scene; }
    public String getSelectedType() { return accountTypeBox.getValue(); }
    public String getInitialDeposit() { return initialDepositField.getText(); }
    public String getEmployerName() { return employerNameField.getText(); }
    public String getEmployerAddress() { return employerAddressField.getText(); }
    public Button getCreateButton() { return createButton; }
    public Button getBackButton() { return backButton; }
    public void showNewAccountNumber(String msg) { messageLabel.setText(msg); }
}
