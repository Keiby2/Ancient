package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Mapa;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerMapConstructor implements Initializable {
    /**
     * Элементы из правого окна, необходимы для выбора типа элемента-карты
     */
    @FXML
    private ImageView imgT11, imgT12, imgT13, imgT14, imgT15, imgT16, imgT17, imgT18,
            imgT21, imgT22, imgT23, imgT24, imgT25, imgT26, imgT27, imgT28;

    @FXML
    private TextField width, height, cellsSize; //размеры карты в клетках и размер в пикселах

    @FXML
    private BorderPane borderPane;
    Stage tipStage = new Stage();
    private ImageView tmp;
    /**
     * Массив элементов карты
     */
    ArrayList<Mapa> maps;

    /**
     * Создание самой карты с элементами на ней
     * @param actionEvent
     */
    @FXML
    private void CreateTable(ActionEvent actionEvent) {
        int w = Integer.parseInt(width.getText());
        int h = Integer.parseInt(height.getText());
        int c = Integer.parseInt(cellsSize.getText());

        GridPane out = new GridPane();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Mapa mapa = new Mapa(i, j, c);

                out.add(mapa.getBox(), i, j);
                out.setPrefHeight(100);
                out.setPrefWidth(100);
                out.setPadding(new Insets(10, 10, 10, 10));
                out.setHgap(10);
                out.setVgap(10);

                maps.add(mapa);
            }
        }

        borderPane.setCenter(out);
    }

    /**
     * Начальная инициализация
     *
     * Добавляется слушатель события нажатия на пункт меню справа
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        maps = new ArrayList<>();
        //---------------------- Клики
        imgT11.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Image i = new Image(String.valueOf(getClass().getResource("img/MapConstructor/lug/lug.gif")));
                SetImgToMap(1, i);
            }
        });

//       Image i = new Image(String.valueOf(getClass().getResource("2.png")));
/*
        imgT21.setImage(i);
        imgT22.setImage(i);
        imgT23.setImage(i);
        imgT24.setImage(i);
        imgT25.setImage(i);
        imgT26.setImage(i);
        imgT27.setImage(i);
        imgT28.setImage(i);

        imgT11.setImage(i);
        imgT12.setImage(i);
        imgT13.setImage(i);
        imgT14.setImage(i);
        imgT15.setImage(i);
        imgT16.setImage(i);
        imgT17.setImage(i);
        imgT18.setImage(i);
*/
    }

    /**
     * Сохранение инфорации о карте в файл
     */
    @FXML
    private void Save() {
        //------------------------ Открытие диалогового окна
        Stage stage = new Stage();

        FileChooser fc = new FileChooser();
        fc.setTitle("Сохранить");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("MAP Files", "*.map"),
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        ;
        File fileOut = fc.showSaveDialog(stage);
        //------------------------------ Подготовка данных для записи
        List<String> list = new LinkedList<>();
        List<String> size = new LinkedList<>();
        System.out.println(maps.size());
        for (Mapa p : maps) {
            list.add(p.getIdString());
            System.out.println(p.getIdString());
        }

        size.add(width.getText());
        size.add(height.getText());
        size.add(cellsSize.getText());

        //------------------------------Запись в файл
        try {
            Files.write(fileOut.toPath(), size, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Files.write(fileOut.toPath(), list, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Чтение информации о карте из файла
     * @param actionEvent
     */
    @FXML
    private void Open(ActionEvent actionEvent) {
        //---------------------------Открытие диалогового окна
        Stage stage = new Stage();

        FileChooser fc = new FileChooser();
        fc.setTitle("Открыть");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("MAP Files", "*.map"),
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        ;

        File fileOut = fc.showOpenDialog(stage);
        //----------------------------чтение данных
        List<String> list = new ArrayList<>();

        try {
            Files.lines(fileOut.toPath(), StandardCharsets.UTF_8)
                    .forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //----------------------- Заполнение полей
        width.setText(list.get(0));
        height.setText(list.get(1));
        cellsSize.setText(list.get(2));

        CreateTable(actionEvent);
    }

    /**
     * Вот хз, честно
     * @param actionEvent
     */
    @FXML
    private void SetId(ActionEvent actionEvent) {
        for (Mapa i : maps) {
            if (i.getCheck()) {
                i.setId(1);
            }
        }

    }

    /**
     * тестовое
     * @param event
     */
    @FXML
    private void moved(MouseEvent event) {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Designe/wind.fxml"));
            tipStage.setTitle("777");
            Scene scene = new Scene(root, 300, 400);
            scene.getStylesheets().add(String.valueOf(getClass().getResource("my2.css")));
//            tipStage.initModality(Modality.WINDOW_MODAL);
            tipStage.setScene(scene);
            tipStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * тестовое
     * @param event
     */
    @FXML
    private void movedEnd(MouseEvent event) {
     //   tipStage.close();
    }

    /**
     * Замена изображения на элементе и установка id
     * @param id
     * @param img
     */
    @FXML
    private void SetImgToMap(int id, Image img){
        for (Mapa i : maps) {
            if (i.getCheck()) {
                i.setId(id);
                i.setImge(img);
            }
        }
    }



}
