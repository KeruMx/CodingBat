package com.codingbat.MapTwo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Optional;

public class FirstSwap extends Application
{
    private Scene scene;
    private VBox mainPane;
    private HBox botones;
    private Button btnSalir,btnObtenerResultado;
    private Label lblResultado;
    private Dialog<Pair<String,String>> dialog;
    private ArrayList<String> cadenas;
    private TextField textFieldCadena;
    private ButtonType siguienteCadena,parar;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.createAndAddComponents();
        this.stage = primaryStage;
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
    private void createAndAddComponents(){
        mainPane = new VBox(15);    mainPane.setAlignment(Pos.CENTER);
        Label titulo = new Label("FirstSwap");
        Label problema = new Label("We'll say that 2 strings \"match\" if they are non-empty and their first chars are the same.\n" +
                "Loop over and then return the given array of non-empty strings as follows:\n" +
                "if a string matches an earlier string in the array, swap the 2 strings in the array.\n" +
                "A particular first char can only cause 1 swap, so once a char has caused a swap,\n" +
                "its later swaps are disabled. Using a map, this can be solved making just one pass\n" +
                "over the array.\nMore difficult than it looks");
        titulo.setAlignment(Pos.CENTER);
        problema.setAlignment(Pos.CENTER);
        botones = new HBox(5);
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(5);
        btnObtenerResultado = new Button("Procedimiento");
        btnObtenerResultado.setOnAction(event -> eventos(true));
        btnSalir = new Button("Salir");
        btnSalir.setOnAction(event -> eventos(false));
        lblResultado = new Label("");

        cadenas = new ArrayList<>();

        dialog = new Dialog<>();
        dialog.setTitle("Entrada Texto");
        dialog.setHeaderText("Ingreso de cadena al arreglo");
        textFieldCadena = new TextField();  textFieldCadena.setPromptText("cadena");
        VBox vBoxDialog=new VBox(10); vBoxDialog.setAlignment(Pos.CENTER);
        vBoxDialog.getChildren().addAll(new Label("Ingresa Una Cadena"),textFieldCadena);
        dialog.getDialogPane().setContent(vBoxDialog);
        siguienteCadena = new ButtonType("SiguienteCadena", ButtonBar.ButtonData.OK_DONE);
        parar = new ButtonType("parar", ButtonBar.ButtonData.FINISH);
        dialog.getDialogPane().getButtonTypes().addAll(siguienteCadena,parar);


        botones.getChildren().addAll(btnObtenerResultado,btnSalir);
        mainPane.getChildren().addAll(titulo,problema,botones,lblResultado);
        scene = new Scene(mainPane);
    }

    private void eventos(boolean opcion){
        if (!opcion){
            stage.close();
        }else{
            showDialogCadenas();
        }
    }

    private void showDialogCadenas(){
        Optional<Pair<String, String>> result = dialog.showAndWait();
        /*if (result.get() == siguienteCadena){

        }else if (result.){

        }*/
    }
}