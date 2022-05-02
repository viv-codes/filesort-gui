package com.example.filesort;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
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
        /**
         * This vbox is the basic structure of the entire view. All other components reside within this vbox.
         */
        VBox vBox = new VBox();

        /**
         * This component is an Hbox used to hold any informational text and stuff at the top of the program, to fill space and serve as a reference
         */
        HBox textBlurb = new HBox();
        Label label = new Label("Welcome to filesort-gui!");
        label.setFont(new Font(20));
        label.setAlignment(Pos.CENTER);
        label.setWrapText(true);
        textBlurb.getChildren().add(label);
        textBlurb.setAlignment(Pos.CENTER);

        /**
         * This component handles the checkbox option menu. It consists of multiple VBoxes inside of an HBox
         */
        HBox optionMenu = new HBox();
        VBox lefCol = new VBox();

        Label leftColLabel = new Label("Sort method:");

        final ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Day: YYYY/MM/DD");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Month: YYYY/MM");
        rb2.setToggleGroup(group);
        RadioButton rb3 = new RadioButton("Year: YYYY");
        rb3.setToggleGroup(group);
        RadioButton rb4 = new RadioButton("Filetype: .png");
        rb4.setToggleGroup(group);

        lefCol.getChildren().addAll(leftColLabel, rb1, rb2, rb3, rb4);
        VBox rightCol = new VBox();

        Label rightColLabel = new Label("Additional options:");
        CheckBox verbose = new CheckBox("Verbose");
        CheckBox excludeSym = new CheckBox("Exclude symlinks");
        CheckBox onlyExtension = new CheckBox("Whitelist file extenison");

        rightCol.getChildren().addAll(rightColLabel, verbose, excludeSym, onlyExtension);
        optionMenu.getChildren().addAll(lefCol, rightCol);
        optionMenu.setMargin(lefCol, new Insets(5,5,5,5));







        /**
         * This component handles the buttons used for input and output directory selection
         */
        HBox dirChooseBox = new HBox();

        DirectoryChooser inputDirChooser = new DirectoryChooser();
        inputDirChooser.setTitle("Filesort - "+VERSION+" - Select input directory");
        DirectoryChooser outputDirChooser = new DirectoryChooser();
        outputDirChooser.setTitle("Filesort - "+VERSION+" - Select output directory");

        Button inputButton = new Button("Select Input Directory");
        inputButton.setFont(new Font(15));
        inputButton.setOnAction(e -> {
            File selectedDirectory = inputDirChooser.showDialog(stage);
//            TODO Here is the hook for model inputdir
        });

        Button outputButton = new Button("Select Output Directory");
        outputButton.setFont(new Font(15));
        outputButton.setOnAction(e -> {
            File selectedDirectory = outputDirChooser.showDialog(stage);
//            TODO Here is the hook for model outputdir
        });

        dirChooseBox.getChildren().addAll(inputButton, outputButton);
        dirChooseBox.setMargin(inputButton, new Insets(20,20,20,20));
        dirChooseBox.setMargin(outputButton, new Insets(20,20,20,20));
//        dirChooseBox.setBorder(new Border(new BorderStroke(Paint.valueOf("Black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

//        Adds all necessary components to the vbox and finishes configuration

        Label processProgresslabel = new Label("Total progress:");
        ProgressBar processProgress = new ProgressBar();
        processProgress.setPrefWidth(450);
        Label copyProgressLabel = new Label("Process progress: "+"(1/2) Indexing input directory");
        ProgressBar copyProgress = new ProgressBar();
        copyProgress.setPrefWidth(450);

        vBox.getChildren().addAll(textBlurb, optionMenu, dirChooseBox, processProgresslabel, processProgress, copyProgressLabel, copyProgress);

        vBox.setMargin(textBlurb, new Insets(30,30,30,30));

        vBox.setAlignment(Pos.CENTER);

        /**
         * JavaFX view final setup occurs here
         */
        Scene scene = new Scene (vBox);
        stage.setTitle("Filesort-GUI - " + VERSION);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}