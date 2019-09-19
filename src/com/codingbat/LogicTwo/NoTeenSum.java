package com.codingbat.LogicTwo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NoTeenSum extends Application
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
        Label titulo = new Label("NoTeenSum");
        Label problema = new Label("Given 3 ints, a b c, return their sum. However, if any of the values is a teen\n" +
                "--in the range 13..19 inclusive -- then that value counts as 0,except 15 and 16\n" +
                "do not count as a teens. Write a separate helper\n" +
                "\"public int fixTeen(int n)\"{Takes int value and returns a number for teen rule\n" +
                "avoiding repeat the teen code 3 times}");
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
            lblResultado.setText("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum());
        }
    }

    private int noTeenSum(){
        a = fixTeen(a);
        b = fixTeen(b);
        c = fixTeen(c);

        return (a+b+c);
    }
    private int fixTeen(int n){
        switch(n){
            case 13:
            case 14:
            case 17:
            case 18:
            case 19:
                n=0;
                break;
        }
        return n;
    }
}