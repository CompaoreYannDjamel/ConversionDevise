package com.example.conversiondevise;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Conversion conversion=new Conversion();
        Label label = new Label("Choississez le type de conversion");
        Label validationLabel = new Label();
        Label validationLabel1 = new Label();

        validationLabel.setVisible(false); // cacher le label de validation
        validationLabel1.setVisible(false);

        ComboBox comboBox = new ComboBox<String>();
        comboBox.getItems().addAll("US-CA", "US-EUR", "CA-US", "CA-EUR", "EUR-US", "EUR-CA");

        TextField textField = new TextField();

        VBox root = new VBox();
        root.getChildren().addAll(label, comboBox, textField, validationLabel,validationLabel1);
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();

        // Créer une Timeline pour mettre à jour la scène toutes les 100 millisecondes
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if (comboBox.getSelectionModel().getSelectedItem() != null && textField.getText().matches("\\d+([.,]\\d+)?")) {
                validationLabel.setText("Champ valide");
                validationLabel.setVisible(true);
                validationLabel1.setVisible(false);

                if(comboBox.getSelectionModel().getSelectedItem().toString()=="US-CA"){
                    validationLabel1.setVisible(true);
                    validationLabel1.setText(String.valueOf(conversion.US_CA(Double.parseDouble(textField.getText())))+" $CA");
                }
                if(comboBox.getSelectionModel().getSelectedItem().toString()=="US-EUR"){
                    validationLabel1.setVisible(true);
                    validationLabel1.setText(String.valueOf(conversion.US_FR(Double.parseDouble(textField.getText())))+" euro");
                }
                if(comboBox.getSelectionModel().getSelectedItem().toString()=="CA-US"){
                    validationLabel1.setVisible(true);
                    validationLabel1.setText(String.valueOf(conversion.CA_US(Double.parseDouble(textField.getText())))+" $US");
                }
                if(comboBox.getSelectionModel().getSelectedItem().toString()=="CA-EUR"){
                    validationLabel1.setVisible(true);
                    validationLabel1.setText(String.valueOf(conversion.CA_FR(Double.parseDouble(textField.getText())))+" euro");
                }
                if(comboBox.getSelectionModel().getSelectedItem().toString()=="EUR-US"){
                    validationLabel1.setVisible(true);
                    validationLabel1.setText(String.valueOf(conversion.FR_US(Double.parseDouble(textField.getText())))+" $US");
                }
                if(comboBox.getSelectionModel().getSelectedItem().toString()=="EUR-CA"){
                    validationLabel1.setVisible(true);
                    validationLabel1.setText(String.valueOf(conversion.FR_CA(Double.parseDouble(textField.getText())))+" $CA");
                }
            } else {
                validationLabel.setText("Champ invalide");
                validationLabel.setVisible(true);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE); // Boucler indéfiniment
        timeline.play(); // Lancer la timeline
    }

    public static void main(String[] args) {
        launch(args);
    }
}
