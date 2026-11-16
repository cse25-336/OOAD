package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class TransactionHistoryView {
    private TextArea historyArea = new TextArea();
    private Button backButton = new Button("Back");
    private Scene scene;

    public TransactionHistoryView() {
        Label title = new Label("Transaction History");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        historyArea.setEditable(false);
        historyArea.setPrefHeight(220);

        VBox box = new VBox(12, title, historyArea, backButton);
        box.setPadding(new Insets(20));
        this.scene = new Scene(box, 420, 340);
    }

    public Scene getScene() { return scene; }
    public void showHistory(String text) { historyArea.setText(text); }
    public Button getBackButton() { return backButton; }
}
