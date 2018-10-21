package sample;

import javafx.scene.image.Image;

/**
 * Created by lushi on 21.10.2018.
 */
public class MapFactory {
    public Image switchImg(String id){
        switch (id){
            case "0": return new Image(String.valueOf(getClass().getResource("img/MapConstructor/river/river_classic.png")));
            case "1": return new Image(String.valueOf(getClass().getResource("img/MapConstructor/ground/ground.png")));
            case "2": return new Image(String.valueOf(getClass().getResource("img/MapConstructor/lug/lug.gif")));
            case "3": return new Image(String.valueOf(getClass().getResource("img/MapConstructor/forest/forest.png")));
            case "4": return new Image(String.valueOf(getClass().getResource("img/MapConstructor/hill/hill.png")));
            case "5": return new Image(String.valueOf(getClass().getResource("img/MapConstructor/mount/mount.png")));
            case "6": return new Image(String.valueOf(getClass().getResource("img/MapConstructor/village/villageGray.jpg")));
            case "7": return new Image(String.valueOf(getClass().getResource("img/MapConstructor/village/villageRed.jpg")));
        }
        return new Image(String.valueOf(getClass().getResource("img/MapConstructor/river/river_classic.png")));
    }
}
