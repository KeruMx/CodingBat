package com.codingbat.LogicOne;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

public class TwoAsOne extends Application
{
    private Scene scene;
    private VBox mainPane;
    private HBox textFields,botones;
    private TextField textFieldA,textFieldB,textFieldC;
    private Button btnSalir,btnObtenerResultado;
    private Label lblResultado;
    private int a,b,c;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.createAndAddComponents();
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    private void createAndAddComponents(){
        mainPane = new VBox(15);
        mainPane.setAlignment(Pos.CENTER);
        Label titulo = new Label("TwoAsOne");
        Label problema = new Label("Given 3 ints, a b c, return true if it is posible to add two of the ints to get the third");
        titulo.setAlignment(Pos.CENTER);
        problema.setAlignment(Pos.CENTER);
        textFields = new HBox(5);
        textFields.setAlignment(Pos.CENTER);
        botones = new HBox(5);
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(5);
        textFieldA = new TextField();   textFieldA.setPromptText("n° a");
        textFieldB = new TextField();   textFieldB.setPromptText("n° b");
        textFieldC = new TextField();   textFieldC.setPromptText("n° c");
        btnObtenerResultado = new Button("Procedimiento");
        btnObtenerResultado.setOnAction(event -> eventos(true));
        btnSalir = new Button("Salir");
        btnSalir.setOnAction(event -> eventos(false));
        lblResultado = new Label("");
        //addComponents
        textFields.getChildren().addAll(textFieldA,textFieldB,textFieldC);
        botones.getChildren().addAll(btnObtenerResultado,btnSalir);
        mainPane.getChildren().addAll(titulo,problema,textFields,botones,lblResultado);

        scene = new Scene(mainPane);
    }

    private void eventos(boolean opcion){
        if (!opcion)
            this.stage.close();
        else{
            a = Integer.parseInt(textFieldA.getText());
            b = Integer.parseInt(textFieldB.getText());
            c = Integer.parseInt(textFieldC.getText());
            lblResultado.setText("TwoAsOne("+a+","+b+","+c+") -> "+twoAsOne());
        }
    }

    private boolean twoAsOne(){
        if ((a+b==c) || (a+c==b) || (c+b==a))
            return true;
        else
            return false;
    }
}