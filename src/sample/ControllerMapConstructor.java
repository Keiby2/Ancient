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
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    //------------------------------------------------------------
    // Элемента из Основного раздела справа
    @FXML
    private ImageView imgBase0, imgBase1, imgBase2, imgBase3,
            imgBase4, imgBase5, imgBase6, imgBase7, imgBase8;
    @FXML
    private VBox Vbox01, Vbox11, Vbox02, Vbox12, Vbox03, Vbox13, Vbox04, Vbox14;
    //-----------------------------------------------------------
    //Инфор для заполнения ячейки карты
    private Image imgTMP;
    ImageBuffer imgBuffer;
    @FXML
    ImageView ImgSelect;
    GridPane gridPane;
    //-----------------------------------------------------------
    @FXML
    private TextField width, height, cellsSize; //размеры карты в клетках и размер в пикселах
    //-----------------------------------------------------------
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
     *
     * @param actionEvent
     */
    @FXML
    private void CreateTable(ActionEvent actionEvent) {
        int w = Integer.parseInt(width.getText());
        int h = Integer.parseInt(height.getText());
        int c = Integer.parseInt(cellsSize.getText());

        gridPane = new GridPane();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Mapa mapa = new Mapa(i, j, c);

                mapa.getImg().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mapa.getImg().setImage(imgBuffer.getImg());
                        System.out.println("ID " + imgBuffer.getId());
                        mapa.setId(imgBuffer.getId());
                        //    event.consume();
                    }
                });
                gridPane.add(mapa.getBox(), i, j);
                gridPane.setPrefHeight(100);
                gridPane.setPrefWidth(100);
                gridPane.setPadding(new Insets(10, 10, 10, 10));
                gridPane.setHgap(10);
                gridPane.setVgap(10);

                maps.add(mapa);
            }
        }

        borderPane.setCenter(gridPane);
    }


    /**
     * Начальная инициализация
     * <p>
     * Добавляется слушатель события нажатия на пункт меню справа
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        maps = new ArrayList<>();
        imgBuffer = new ImageBuffer();
        MapFactory factoryMap = new MapFactory();
        ImgSelect.setImage(new Image(String.valueOf(getClass().getResource("img/1.png"))));

        //--------------------- Щелчок по картинке справа выбирает картинку, для дальнейшего рисования на карте
        imgBase0.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgBuffer.setId("0");
                imgBuffer.setImg(factoryMap.switchImg("0"));
                ImgSelect.setImage(imgBuffer.getImg());
            }
        });
        imgBase1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgBuffer.setId("1");
                imgBuffer.setImg(factoryMap.switchImg("1"));
                ImgSelect.setImage(imgBuffer.getImg());
            }
        });
        imgBase2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgBuffer.setId("2");
                imgBuffer.setImg(factoryMap.switchImg("2"));
                ImgSelect.setImage(imgBuffer.getImg());
            }
        });
        imgBase3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgBuffer.setId("3");
                imgBuffer.setImg(factoryMap.switchImg("3"));
                ImgSelect.setImage(imgBuffer.getImg());
            }
        });
        imgBase4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgBuffer.setId("4");
                imgBuffer.setImg(factoryMap.switchImg("4"));
                ImgSelect.setImage(imgBuffer.getImg());
            }
        });
        imgBase5.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgBuffer.setId("5");
                imgBuffer.setImg(factoryMap.switchImg("5"));
                ImgSelect.setImage(imgBuffer.getImg());
            }
        });
        imgBase6.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgBuffer.setId("6");
                imgBuffer.setImg(factoryMap.switchImg("6"));
                ImgSelect.setImage(imgBuffer.getImg());
            }
        });
        imgBase7.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgBuffer.setId("7");
                imgBuffer.setImg(factoryMap.switchImg("7"));
                ImgSelect.setImage(imgBuffer.getImg());
            }
        });
        //-------------------------------------------------------

        //---------------------- Клики
       /* imgT11.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Image i = new Image(String.valueOf(getClass().getResource("img/MapConstructor/lug/lug.gif")));
               maps.SetId(1, i);
            }
        });*/


     /*   imgBase0.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("PRESSED!!");
                imgBase0.setStyle("-fx-border-color: red");
                imgBase0.getStyleClass().add("imgSelected");
                imgBuffer.setId(0);
                imgBuffer.setImg(new Image(String.valueOf(getClass().getResource("img/MapConstructor/river/river_classic.png"))));
            }
        });*/


    }

    /**
     * Сохранение инфорации о карте в файл
     */
    @FXML
    private void Save() {

        System.out.println(maps);
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
            System.out.println(p.getId());
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
     *
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


        System.out.println("Read: " + list);

        int w = Integer.parseInt(list.get(0));
        int h = Integer.parseInt(list.get(1));
        int c = Integer.parseInt(list.get(2));

        int counter = 3;
        GridPane out = new GridPane();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Mapa mapa = new Mapa(i, j, c, list.get(counter));
                counter++;

                mapa.getImg().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mapa.getImg().setImage(imgBuffer.getImg());
                        System.out.println("ID " + imgBuffer.getId());
                        mapa.setId(imgBuffer.getId());
                        //    event.consume();
                    }
                });
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


    @FXML
    private void SetId(ActionEvent actionEvent) {
        for (Mapa i : maps) {
            if (i.getCheck()) {
                i.setId("1");
            }
        }

    }



 /*   @FXML
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
    }*/


  /*  @FXML
    private void movedEnd(MouseEvent event) {
        //   tipStage.close();
    }*/
}
