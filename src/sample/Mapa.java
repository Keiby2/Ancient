package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Mapa {

    private ImageView img;
    private HBox bpx;
    private Boolean check = false;
    private int x, y;
    private int id;

    /**
     * Строит класс элемент карты, так же тут описано осбытие,
     * при котором клик - выделяет элемент, повторный снимает выделение.
     *
     * И пробное всплывающее меню
     *
     * @param x положение по оси х
     * @param y положение по оси у
     * @param c размер элемента (квадрат)
     */
    public Mapa(int x, int y, int c) {
        img = new ImageView();
        bpx = new HBox();
        Image im = new Image(String.valueOf(getClass().getResource("img/1.png")));
        img.setImage(im);
        img.setFitHeight(c);
        img.setFitWidth(c);
        img.getStyleClass().add("grid");
        img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(check);
                if (!check) {
                    System.out.println("red");
                    bpx.getStyleClass().add("imgSelected");
                    bpx.getStyleClass().remove("imgUnSelected");
                    check = true;
                } else if(check) {
                    System.out.println("blue");
                    bpx.getStyleClass().add("imgUnSelected");
                    bpx.getStyleClass().remove("imgSelected");
                    check = false;
                }
            //    event.consume();
            }
        });

        bpx.getChildren().add(img);
        this.x = x;
        this.y = y;
        this.id = 0;


        //--------------
        Stage tipStage = new Stage();
        //----------------------
        img.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                Parent root = null;
//                try {
//                    root = FXMLLoader.load(getClass().getResource("Designe/wind.fxml"));
//                    tipStage.setTitle("777");
//                    Scene scene = new Scene(root, 300, 400);
//                    scene.getStylesheets().add(String.valueOf(getClass().getResource("my.css")));
//                    tipStage.setScene(scene);
//                    tipStage.show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });
        //----------------------
        img.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipStage.close();
            }
        });
    }

    // Геттеры и сеттеры
    public HBox getBox() {
        return bpx;
    }

    public ImageView getImg() {
        return img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public void setImge(Image img) {
        this.img.setImage(img);
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getIdString() {
        return Integer.toString(id);
    }
}
