package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Model.Squad;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Контроллер главного меню
 */
public class MainMenuController implements Initializable{

    private String version, lastUpdate;
    private Squad squad;        //model

    //---------------------------------------------
    @FXML
    private Label Version, LastUpdate;
    //----------------------------------------------

    /**
     * Нажатие на кнопку инициирует открытие окна первого боя
     * @param actionEvent
     */
    @FXML
    public void ppcBtn(ActionEvent actionEvent) {
      FirstMap firstMap = new FirstMap();
      firstMap.run(actionEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReadAbout();
    }

    /**
     * Отображает форму Главного меню
     * @param primaryStage
     * @throws IOException
     */
    public void run(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Designe/MainMenu.fxml"));
        primaryStage.setTitle("Ancient of Empires");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    private void TestAttack(ActionEvent actionEvent) throws IOException {
        System.out.println("open");

        Parent root = FXMLLoader.load(getClass().getResource("Designe/AttackMenu.fxml"));
        Stage primaryStage= new Stage();
        primaryStage.setTitle("Preview Attack");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Выводит информацию об авторах
     * @param actionEvent
     */
    @FXML
    private void showAbout(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация об авторах данного шедевра");
        alert.setHeaderText("М.С. совместо с ЛёхаПродакшн представляют:");
        alert.setContentText("Ancient Of Empires");
        alert.show();
    }

    /**
     * Завершает работу приложения
     * @param actionEvent
     */
    @FXML
    private void exit(ActionEvent actionEvent){
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void openMapConstructor(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Designe/MapConstructor.fxml"));
        Stage primaryStage= new Stage();
        primaryStage.setTitle("Map Constructor");
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root, 700, 400);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("my2.css")));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Чтение из файла конфига инфы о версии и последнем апдейте и вывод в главном меню
     */
    private void ReadAbout(){
        ArrayList<String> listConf = new ArrayList<>();
        try {
            Path path = Paths.get(new URI(String.valueOf(getClass().getResource("config.txt"))));
            Files.lines(path, StandardCharsets.UTF_8)
                    .forEach(listConf::add);
            version = listConf.get(0);
            lastUpdate = listConf.get(1);

            Version.setText("Version: " + version);
            LastUpdate.setText("LastUpdate: " + lastUpdate);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
