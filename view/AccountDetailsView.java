package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AccountDetailsView {
    private Label headerLabel = new Label("Customer Dashboard");
    private ComboBox<String> accountList = new ComboBox<>();
    private TextArea summaryArea = new TextArea();
    private Button depositBtn = new Button("Deposit");
    private Button withdrawBtn = new Button("Withdraw");
    private Button openAccountBtn = new Button("Open Account");
    private Button historyBtn = new Button("History");
    private Button salaryBtn = new Button("Credit Salary");
    private Button logoutBtn = new Button("Logout");
    private Scene scene;

    public AccountDetailsView() {
        headerLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        accountList.setPromptText("Choose Account");
        accountList.setMaxWidth(Double.MAX_VALUE);
        summaryArea.setEditable(false);
        summaryArea.setPrefHeight(160);

        HBox row1 = new HBox(8, depositBtn, withdrawBtn, openAccountBtn);
        HBox row2 = new HBox(8, historyBtn, salaryBtn, logoutBtn);

        VBox box = new VBox(12, headerLabel, accountList, summaryArea, row1, row2);
        box.setPadding(new Insets(20));
        this.scene = new Scene(box, 450, 380);
    }

    public Scene getScene() { return scene; }
    public Label getHeaderLabel() { return headerLabel; }
    public ComboBox<String> getAccountList() { return accountList; }
    public void showAccountSummary(String text) { summaryArea.setText(text); }
    public Button getDepositBtn() { return depositBtn; }
    public Button getWithdrawBtn() { return withdrawBtn; }
    public Button getOpenAccountBtn() { return openAccountBtn; }
    public Button getHistoryBtn() { return historyBtn; }
    public Button getSalaryBtn() { return salaryBtn; }
    public Button getLogoutBtn() { return logoutBtn; }
}
