package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Model.Squad;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер главного меню
 */
public class MainMenuController implements Initializable{

    private Squad squad;        //model

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
}
