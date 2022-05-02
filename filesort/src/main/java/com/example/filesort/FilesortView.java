package com.example.filesort;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class FilesortView extends Application {
    String VERSION = "v0.0.1";
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(FilesortView.class.getResource("filesort-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        VBox vBox = new VBox();

        HBox textBlurb = new HBox();
        Label label = new Label("Welcome to filesort-gui!\nEventually there will be helpful stuff here.");
        label.setFont(new Font(20));
        label.setAlignment(Pos.CENTER);
        label.setWrapText(true);
        textBlurb.getChildren().add(label);

        DirectoryChooser inputDirChooser = new DirectoryChooser();
        DirectoryChooser outputDirChooser = new DirectoryChooser(); // TODO This might be redundant, IDK

        Button inputButton = new Button("Select Input Directory");
        inputButton.setFont(new Font(15));
        inputButton.setOnAction(e -> {
            File selectedDirectory = inputDirChooser.showDialog(stage);
//            TODO Here is the hook for model inputdir
        });

        Button outputButton = new Button("Select Output Directory");
        outputButton.setFont(new Font(15));
        inputButton.setOnAction(e -> {
            File selectedDirectory = outputDirChooser.showDialog(stage);
//            TODO Here is the hook for model outputdir
        });

        vBox.getChildren().addAll(textBlurb, inputButton, outputButton);
        vBox.setMargin(textBlurb, new Insets(30,30,30,30));
        vBox.setMargin(inputButton, new Insets(10,30,30,30));
        vBox.setMargin(outputButton, new Insets(0,5,20,0));

        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene (vBox);
        stage.setTitle("Filesort-GUI - " + VERSION);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}