package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lushi on 12.08.2018.
 */
public class AttackController implements Initializable {

    @FXML
    private ImageView img1, img2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        img1.setImage(new Image(String.valueOf(getClass().getResource("img/img1.gif"))));
        img2.setImage(new Image(String.valueOf(getClass().getResource("img/img2.gif"))));
    }


}
