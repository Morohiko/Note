package Face;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import data.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Face extends Application {
    @FXML
    private Button btnFile;
    @FXML
    private TextArea txtArea;
    @FXML
    private Button btnRead;
    @FXML
    private Button btnWrite;
    @FXML
    private TextField txtField;

    public static void main(String[] args) {
        launch(args);
    }

    private Scene scene;
    private Stage stage;
    private File file;
    private boolean prot = true;////
    private IOFileVar1 io = new IOFileVar1();
    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Face.fxml"));
        } catch (IOException e) {
            System.out.println("FXML");
        }
        scene = new Scene(root);
        primaryStage.setTitle("Note");
        primaryStage.setScene(scene);
        primaryStage.show();
        stage = primaryStage;
    }


    @FXML
    void btnFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        file = fileChooser.showOpenDialog(stage);
        if (file==null) btnFile.setStyle("-fx-border-color: #990000");
        else {
            try {
                io.initFile(file.getPath());
            } catch (Exception e) {
                System.out.println("initFIle");
            }
            btnFile.setStyle("-fx-border-color: #009900");
        }
    }

    public void btnWrite(ActionEvent actionEvent) {
        try {

//            if (txtArea.getText().equals("")){///
//                txtArea.setText("");
//                btnRead.setStyle("-fx-border-color: green");
//                prot = true;
//                return;
//            }
            io.writeToFile(file.getPath(), txtArea.getText());
        }catch (Exception ex){
            txtArea.setText(txtArea.getText() + '\n' + "FileNotFound");
            return;
        }
        txtArea.setText("");
    }

    public void btnRead(ActionEvent actionEvent) {
        if(!prot)return;
        try {
            txtArea.setText(io.readFromFile(file.getPath()));
        }catch (Exception ex){
            txtArea.setText(txtArea.getText() + '\n' + "FileNotFound");
        }
        btnWrite.setStyle("-fx-border-color: darkred");
    }


    private String txtInField = "";
    private ArrayList<Integer> array = new ArrayList<Integer>();
    private int number = 0;
    public void fldSearch(KeyEvent keyEvent) {
        if(keyEvent.getCode().getName().equals("Enter")){
            if (!txtInField.equals(txtField.getText())){
                txtInField = txtField.getText();
                array = new ArrayList<Integer>();
                array.add(0);
                number = 0;
                System.out.println("TxtInField = " + txtInField);
//

                return;
            }
            number++;
            try {
                txtArea.setScrollTop(array.get(number));
            }catch (Exception e){
                number = 0;
                txtArea.setScrollLeft(0);
            }
        }
        //System.out.println("enter");
    }


}
