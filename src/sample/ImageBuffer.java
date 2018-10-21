package sample;

import javafx.scene.image.Image;

/**
 * Created by lushi on 21.10.2018.
 */
public class ImageBuffer {
    private Image img;
    private String id;

    public ImageBuffer() {
        id = "0";
        img = new Image(String.valueOf(getClass().getResource("img/1.png")));
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

